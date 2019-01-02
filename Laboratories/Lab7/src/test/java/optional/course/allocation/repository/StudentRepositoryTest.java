package optional.course.allocation.repository;

import optional.course.allocation.model.person.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class StudentRepositoryTest {

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
    public void testCRUD() {
        // Create
        Student student = new Student();
        student.setSemester(1);
        student.setYearOfStudy(1);
        student.setName("Test");

        studentRepository.save(student);

        // Read
        Student storedStudent = studentRepository.findById(student.getId());
        assertEquals(storedStudent, student);

        // Delete
        studentRepository.deleteById(student.getId());

        storedStudent = studentRepository.findById(student.getId());
        assertNull(storedStudent);
    }
}
