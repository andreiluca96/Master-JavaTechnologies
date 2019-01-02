package optional.course.allocation.queries;

import optional.course.allocation.model.person.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class AllStudents {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        final List<Student> resultList = query.getResultList();

        // To String doesn't work because of circular references from JPA.
        System.out.println("Students: ");
        for (Student s : resultList) {
            System.out.println(s.getName());
        }
    }
}
