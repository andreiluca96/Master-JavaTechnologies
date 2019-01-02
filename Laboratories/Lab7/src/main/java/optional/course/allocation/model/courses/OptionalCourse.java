package optional.course.allocation.model.courses;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import optional.course.allocation.model.Grade;
import optional.course.allocation.model.Package;
import optional.course.allocation.model.person.Lecturer;
import optional.course.allocation.model.preferences.CoursePreference;
import optional.course.allocation.model.preferences.StudentPreference;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("optional")
@NoArgsConstructor
@ToString
public class OptionalCourse extends Course {
    @Builder(builderMethodName = "optionalCourseBuilder")
    public OptionalCourse(int id, String name, String shortName, int year, int semester, String url, Lecturer lecturer, int studyGroupsCount, List<Grade> grade, Package aPackage, CoursePreference targetCoursePreference, List<CoursePreference> preferredCourse, List<StudentPreference> preferredStudentCourse) {
        super(id, name, shortName, year, semester, url, lecturer, studyGroupsCount, grade, aPackage, targetCoursePreference, preferredCourse, preferredStudentCourse);
    }
}
