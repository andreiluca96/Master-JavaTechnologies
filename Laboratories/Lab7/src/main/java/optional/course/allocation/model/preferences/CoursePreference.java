package optional.course.allocation.model.preferences;

import lombok.Data;
import lombok.ToString;
import optional.course.allocation.model.courses.Course;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course_preferences")
@Data
@ToString
public class CoursePreference {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    @JoinColumn(name = "target_course_id",
            referencedColumnName = "id")
    @OneToOne
    private Course targetCourse;

    @ManyToOne
    @JoinColumn(name = "preffered_course_id", referencedColumnName = "id")
    private Course preferredCourse;
}
