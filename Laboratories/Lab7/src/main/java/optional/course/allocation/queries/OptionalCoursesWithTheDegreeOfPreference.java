package optional.course.allocation.queries;

import optional.course.allocation.model.courses.Course;
import optional.course.allocation.model.courses.OptionalCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class OptionalCoursesWithTheDegreeOfPreference {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Course> query = entityManager
                .createQuery("SELECT c FROM Course c WHERE TYPE(c) = :type", Course.class)
                .setParameter("type", OptionalCourse.class);
        final List<Course> resultList = query.getResultList();

        // To String doesn't work because of circular references from JPA.
        System.out.println("OptionalCoursesWithTheDegreeOfPreference: ");
        for (Course c : resultList) {
//            if (c instanceof OptionalCourse) {
                System.out.println(c.getName() + " " + c.getPreferredStudentCourse().size());
//            }
        }
    }
}
