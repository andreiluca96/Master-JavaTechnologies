package optional.course.allocation.model.courses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import optional.course.allocation.model.person.Lecturer;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* JPA */
@Entity
@Table(name = "courses")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "course_type", discriminatorType = DiscriminatorType.STRING)
/* Lombok */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
