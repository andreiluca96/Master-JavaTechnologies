package optional.course.allocation;

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
        lecturer.setName("Cristian Frasinaru");
        lecturer.setPosition("Lect. Dr.");

        Student student = new Student();
        student.setName("Luca Andrei");
        student.setYearOfStudy(1);

        entityManager.persist(lecturer);
        entityManager.persist(student);

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
