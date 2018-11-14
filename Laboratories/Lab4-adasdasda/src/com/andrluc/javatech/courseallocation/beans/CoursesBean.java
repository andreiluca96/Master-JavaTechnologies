package com.andrluc.javatech.courseallocation.beans;

import com.andrluc.javatech.courseallocation.model.Course;
import com.andrluc.javatech.courseallocation.repository.CoursesRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "Courses", eager = true)
@RequestScoped
public class CoursesBean {

    private final CoursesRepository coursesRepository =
            new CoursesRepository();

    public List<Course> getAll() {
        return coursesRepository.findAll();
    }
}
