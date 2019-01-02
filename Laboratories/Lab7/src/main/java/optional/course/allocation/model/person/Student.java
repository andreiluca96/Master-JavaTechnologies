package optional.course.allocation.model.person;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import optional.course.allocation.model.Grade;
import optional.course.allocation.model.preferences.StudentPreference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString
public class Student extends Person {
    @Column(name = "year_of_study")
    private int yearOfStudy;

    @Column(name = "semester")
    private int semester;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.MERGE
    )
    private List<Grade> grade;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.MERGE
    )
    private List<StudentPreference> studentPreferences;
}
