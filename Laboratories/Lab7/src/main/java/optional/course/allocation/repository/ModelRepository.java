package optional.course.allocation.repository;

import java.util.List;

public interface ModelRepository<T> {
    int count();

    // Create
    void save(T entity);

    // Read
    T findById(int id);
    List<T> findAll();
    boolean existsById(int id);

    // Delete
    void delete();
    void deleteById(int id);
}
