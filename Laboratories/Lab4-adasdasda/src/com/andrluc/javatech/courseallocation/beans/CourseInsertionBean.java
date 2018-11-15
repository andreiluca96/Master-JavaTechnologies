package com.andrluc.javatech.courseallocation.beans;

import com.andrluc.javatech.courseallocation.model.Course;
import com.andrluc.javatech.courseallocation.model.Lecturer;
import com.andrluc.javatech.courseallocation.repository.CoursesRepository;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.UUID;

@ManagedBean(name = "CourseInsertion", eager = true)
@ApplicationScoped
public class CourseInsertionBean {
    private final CoursesRepository coursesRepository =
            new CoursesRepository();

    private String name;
    private String shortName;
    private String year;
    private String semester;
    private String url;
    private String lecturer;
    private String studyGroupsCount;
    private String optionalPackageName;

    public CoursesRepository getCoursesRepository() {
        return coursesRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getStudyGroupsCount() {
        return studyGroupsCount;
    }

    public void setStudyGroupsCount(String studyGroupsCount) {
        this.studyGroupsCount = studyGroupsCount;
    }

    public String getOptionalPackageName() {
        return optionalPackageName;
    }

    public void setOptionalPackageName(String optionalPackageName) {
        this.optionalPackageName = optionalPackageName;
    }

    public void save() {
        Course course = new Course();
        course.setId(UUID.randomUUID().toString());
        course.setName(name);
        course.setShortName(shortName);
        course.setYear(Integer.parseInt(year));
        course.setSemester(Integer.parseInt(semester));
        course.setLecturer(new Lecturer(lecturer));
        course.setUrl(url);
        course.setOptionalPackageName(optionalPackageName);
        course.setStudyGroupsCount(Integer.parseInt(studyGroupsCount));

        coursesRepository.save(course);
    }
}
