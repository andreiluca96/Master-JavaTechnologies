package optional.course.allocation.model.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import optional.course.allocation.model.courses.Course;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lecturers")
@ToString
@Data
@EqualsAndHashCode(callSuper = true)
public class Lecturer extends Person {
    @Column(name = "position")
    private String position;

    @OneToMany(
            mappedBy = "lecturer",
            cascade = CascadeType.MERGE
    )
    private List<Course> courses;
}
