package com.andrluc.javatech.courseallocation.beans;

import com.andrluc.javatech.courseallocation.model.OptionalCoursesPackage;
import com.andrluc.javatech.courseallocation.repository.OptionalCoursesPackageRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.UUID;

@ManagedBean(name = "OptionalCoursesPackageInsertion", eager = true)
@RequestScoped
public class OptionalCoursesPackageInsertionBean {
    private final OptionalCoursesPackageRepository optionalCoursesPackageRepository =
            new OptionalCoursesPackageRepository();

    private String name;
    private String year;
    private String semester;
    private String coursesCount;

    private List<String> cachedEntries;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCoursesCount() {
        return coursesCount;
    }

    public void setCoursesCount(String coursesCount) {
        this.coursesCount = coursesCount;
    }

    public void save() {
        OptionalCoursesPackage optionalCoursesPackage = new OptionalCoursesPackage();
        optionalCoursesPackage.setId(UUID.randomUUID().toString());
        optionalCoursesPackage.setName(name);
        optionalCoursesPackage.setYear(Integer.parseInt(year));
        optionalCoursesPackage.setSemester(Integer.parseInt(semester));
        optionalCoursesPackage.setCoursesCount(Integer.parseInt(coursesCount));

        optionalCoursesPackageRepository.save(optionalCoursesPackage);
    }

    public List<String> getCachedEntries() {
        return cachedEntries;
    }

    public void setCachedEntries(List<String> cachedEntries) {
        this.cachedEntries = cachedEntries;
    }
}
