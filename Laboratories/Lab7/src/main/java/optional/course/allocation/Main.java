package optional.course.allocation;

import optional.course.allocation.model.courses.CompulsoryCourse;
import optional.course.allocation.model.person.Lecturer;
import optional.course.allocation.model.person.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Lecturer lecturer = new Lecturer();
//        lecturer.setId(1);
        lecturer.setName("Cristian Frasinaru");
        lecturer.setPosition("Lect. Dr.");

        Student student = new Student();
//        student.setId(1);
        student.setName("Luca Andrei");
        student.setYearOfStudy(1);

        CompulsoryCourse javaCourse = CompulsoryCourse.compulsoryCourseBuilder()
//                .id(1)
                .name("Java Technologies")
                .shortName("Java")
                .year(2)
                .semester(1)
                .url("tbd")
                .lecturer(lecturer)
                .studyGroupsCount(15)
                .build();

        entityManager.persist(lecturer);
        entityManager.persist(javaCourse);
        entityManager.persist(student);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
