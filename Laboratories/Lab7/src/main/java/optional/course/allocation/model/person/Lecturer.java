package optional.course.allocation.model.person;

import optional.course.allocation.model.courses.Course;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lecturers")
public class Lecturer extends Person {
    @Column(name = "position")
    private String position;

    @OneToMany(
            mappedBy = "lecturer",
            cascade = CascadeType.MERGE
    )
    private List<Course> courses;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
