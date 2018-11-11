package com.andrluc.javatech.courseallocation.repository;

import java.util.List;

public interface ModelRepository<T> {
    int count();

    // Create
    void save(T entity);

    // Read
    T findById(String id);
    List<T> findAll();
    boolean existsById(String id);

    // Delete
    void delete();
    void deleteById(String id);
}
