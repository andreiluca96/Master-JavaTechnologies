package optional.course.allocation.model;

import lombok.Data;
import lombok.ToString;
import optional.course.allocation.model.courses.Course;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "packages")
@Data
@ToString
public class Package {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "semester")
    private int semester;

    @OneToMany(
            mappedBy = "aPackage",
            cascade = CascadeType.MERGE
    )
    private List<Course> courses;
}
