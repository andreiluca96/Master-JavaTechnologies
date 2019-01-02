package optional.course.allocation.model.preferences;

import lombok.Data;
import lombok.ToString;
import optional.course.allocation.model.Package;
import optional.course.allocation.model.courses.Course;
import optional.course.allocation.model.person.Student;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_preferences")
@Data
@ToString
public class StudentPreference {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "preferred_course_id", referencedColumnName = "id")
    private Course preferredCourse;

    @Column(name = "preferred_course_priority")
    private int preferredCoursePriority;

    @ManyToOne
    @JoinColumn(name = "package_id", referencedColumnName = "id")
    private Package aPackage;
}
