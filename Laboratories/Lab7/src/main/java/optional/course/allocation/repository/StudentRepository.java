package optional.course.allocation.repository;

import lombok.AllArgsConstructor;
import optional.course.allocation.model.person.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@AllArgsConstructor
public class StudentRepository implements ModelRepository<Student> {
    private EntityManager entityManager;

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void save(Student entity) {
        entityManager.getTransaction().begin();

        entityManager.persist(entity);

        entityManager.getTransaction().commit();
    }

    @Override
    public Student findById(int id) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        final List<Student> resultList = query.getResultList();

        for (Student s : resultList) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteById(int id) {
        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery(
                "DELETE FROM Student s WHERE s.id = :id");
        query.setParameter("id", id).executeUpdate();

        entityManager.getTransaction().commit();
    }
}
