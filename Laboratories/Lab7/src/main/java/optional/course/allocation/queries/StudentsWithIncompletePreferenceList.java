package optional.course.allocation.queries;

import com.google.common.collect.Lists;
import optional.course.allocation.model.Package;
import optional.course.allocation.model.courses.Course;
import optional.course.allocation.model.person.Student;
import optional.course.allocation.model.preferences.StudentPreference;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsWithIncompletePreferenceList {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Student> studentQuery = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        final List<Student> students = studentQuery.getResultList();

        TypedQuery<Package> packageQuery = entityManager.createQuery("SELECT p FROM Package p", Package.class);
        final List<Package> packages = packageQuery.getResultList();

        List<Student> studentsWithIncompletePreferenceList = Lists.newArrayList(students);

        for (Student student : students) {
            for (Package aPackage : packages) {
                if (student.getYearOfStudy() == aPackage.getYear() &&
                        student.getSemester() == aPackage.getSemester()) {
                    List<Course> chosenCourses = student.getStudentPreferences()
                            .stream()
                            .map(StudentPreference::getPreferredCourse)
                            .collect(Collectors.toList());
                    if (chosenCourses.containsAll(aPackage.getCourses())) {
                        studentsWithIncompletePreferenceList.remove(student);
                    }
                }
            }
        }

        System.out.println("StudentsWithIncompletePreferenceList: ");
        for (Student student : studentsWithIncompletePreferenceList) {
            System.out.println(student.getName());
        }
    }
}
