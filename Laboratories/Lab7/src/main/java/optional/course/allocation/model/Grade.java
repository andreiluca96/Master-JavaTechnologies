package optional.course.allocation.model;

import lombok.Data;
import lombok.ToString;
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
@Table(name = "grades")
@Data
@ToString
public class Grade {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    @Column(name = "grade_value")
    private int value;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    protected Course course;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    protected Student student;
}
