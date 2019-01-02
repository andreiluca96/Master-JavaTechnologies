package optional.course.allocation.model.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import optional.course.allocation.model.Grade;
import optional.course.allocation.model.Package;
import optional.course.allocation.model.person.Lecturer;
import optional.course.allocation.model.preferences.CoursePreference;
import optional.course.allocation.model.preferences.StudentPreference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

/* JPA */
@Entity
@Table(name = "courses")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "course_type", discriminatorType = DiscriminatorType.STRING)
/* Lombok */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    protected int id;

    @Column(name = "name")
    protected String name;

    @Column(name = "short_name")
    protected String shortName;

    @Column(name = "year")
    protected int year;

    @Column(name = "semester")
    protected int semester;

    @Column(name = "url")
    protected String url;

    @ManyToOne
    @JoinColumn(name = "lecturer_id", referencedColumnName = "id")
    protected Lecturer lecturer;

    @Column(name = "study_groups_count")
    protected int studyGroupsCount;

    @OneToMany(
            mappedBy = "course",
            cascade = CascadeType.MERGE
    )
    private List<Grade> grade;

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "id")
    protected Package aPackage;

    @OneToOne(mappedBy = "targetCourse")
    private CoursePreference targetCoursePreference;

    @OneToMany(
            mappedBy = "preferredCourse",
            cascade = CascadeType.MERGE
    )
    private List<CoursePreference> preferredCourse;

    @OneToMany(
            mappedBy = "preferredCourse",
            cascade = CascadeType.MERGE
    )
    private List<StudentPreference> preferredStudentCourse;
}
