package optional.course.allocation.model.courses;

import lombok.Builder;
import lombok.NoArgsConstructor;
import optional.course.allocation.model.person.Lecturer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("compulsory")
@NoArgsConstructor
public class CompulsoryCourse extends Course {
    @Builder(builderMethodName = "compulsoryCourseBuilder")
    public CompulsoryCourse(int id, String name, String shortName, int year, int semester, String url, Lecturer lecturer, int studyGroupsCount) {
        super(id, name, shortName, year, semester, url, lecturer, studyGroupsCount);
    }
}
