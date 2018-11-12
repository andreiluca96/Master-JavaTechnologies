package com.andrluc.javatech.courseallocation.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "Index", eager = true)
@RequestScoped
public class IndexBean {
    public String goToOptionalCoursesPackagePage() {
        return "optional_courses_packages?faces-redirect=true";
    }

    public String goToLecturersPage() {
        return "lecturers?faces-redirect=true";
    }

    public String goToCoursesPage() {
        return "courses?faces-redirect=true";
    }
}
