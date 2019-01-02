package optional.course.allocation.repository;

import com.google.common.base.Stopwatch;
import optional.course.allocation.model.person.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class SecondLevelCacheTest {
    private StudentRepository studentRepository;
    private EntityManager entityManager;

    @Before
    public void setup() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("persistenceUnitName");

        entityManager = entityManagerFactory.createEntityManager();

        studentRepository = new StudentRepository(entityManager);
    }

    @After
    public void tearDown() {
        entityManager.close();
    }

    @Test
    public void testSecondLevelCache() {
        // Create
        Student student = new Student();
        student.setSemester(1);
        student.setYearOfStudy(1);
        student.setName("Test");

        studentRepository.save(student);

        /* First retrieval */
        Stopwatch stopwatch1 = Stopwatch.createStarted();
        studentRepository.findById(student.getId());
        stopwatch1.stop();

        /* Second retrieval, should hit the cache. */
        Stopwatch stopwatch2 = Stopwatch.createStarted();
        studentRepository.findById(student.getId());
        stopwatch2.stop();

        System.out.println("First retrieval: ");
        System.out.println(stopwatch1.elapsed(TimeUnit.NANOSECONDS));

        System.out.println("Second retrieval: ");
        System.out.println(stopwatch2.elapsed(TimeUnit.NANOSECONDS));

        assertTrue(stopwatch2.elapsed(TimeUnit.NANOSECONDS) < stopwatch1.elapsed(TimeUnit.NANOSECONDS));
    }
}
