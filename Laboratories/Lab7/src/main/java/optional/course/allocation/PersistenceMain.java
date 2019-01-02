package optional.course.allocation;

import optional.course.allocation.model.Grade;
import optional.course.allocation.model.Package;
import optional.course.allocation.model.courses.CompulsoryCourse;
import optional.course.allocation.model.courses.OptionalCourse;
import optional.course.allocation.model.person.Lecturer;
import optional.course.allocation.model.person.Student;
import optional.course.allocation.model.preferences.CoursePreference;
import optional.course.allocation.model.preferences.StudentPreference;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Lecturer acf = new Lecturer();
        acf.setName("Cristian Frasinaru");
        acf.setPosition("Lect. Dr.");

        Lecturer rb = new Lecturer();
        rb.setName("Razvan Benchea");
        rb.setPosition("Colab. Drd.");

        Student student = new Student();
        student.setName("Luca Andrei");
        student.setYearOfStudy(3);
        student.setSemester(1);

        Student student2 = new Student();
        student2.setName("John Doe");
        student2.setYearOfStudy(3);
        student2.setSemester(1);

        Package aPackage = new Package();
        aPackage.setName("OP1");
        aPackage.setYear(3);
        aPackage.setSemester(1);

        CompulsoryCourse javaCourse = CompulsoryCourse.compulsoryCourseBuilder()
                .name("Java Technologies")
                .shortName("Java")
                .year(2)
                .semester(1)
                .url("tbd")
                .lecturer(acf)
                .studyGroupsCount(15)
                .build();

        OptionalCourse neuralNetworksOptionalCourse = OptionalCourse.optionalCourseBuilder()
                .name("Retele neuronale")
                .shortName("RN")
                .year(3)
                .semester(1)
                .url("tbd")
                .lecturer(rb)
                .studyGroupsCount(3)
                .aPackage(aPackage)
                .build();

        CoursePreference coursePreference = new CoursePreference();
        coursePreference.setPreferredCourse(javaCourse);
        coursePreference.setTargetCourse(neuralNetworksOptionalCourse);

        StudentPreference studentPreference = new StudentPreference();
        studentPreference.setAPackage(aPackage);
        studentPreference.setPreferredCourse(neuralNetworksOptionalCourse);
        studentPreference.setStudent(student);
        studentPreference.setPreferredCoursePriority(1);

        Grade grade = new Grade();
        grade.setValue(10);
        grade.setStudent(student);
        grade.setCourse(javaCourse);

        entityManager.persist(rb);
        entityManager.persist(acf);
        entityManager.persist(javaCourse);
        entityManager.persist(neuralNetworksOptionalCourse);
        entityManager.persist(student);
        entityManager.persist(student2);
        entityManager.persist(aPackage);
        entityManager.persist(grade);
        entityManager.persist(coursePreference);
        entityManager.persist(studentPreference);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
