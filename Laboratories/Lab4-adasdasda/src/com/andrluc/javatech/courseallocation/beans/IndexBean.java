package com.andrluc.javatech.courseallocation.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "Index", eager = true)
@SessionScoped
public class IndexBean {
    private String sessionId = null;
    public String goToOptionalCoursesPackagePage() {
        return "optional_courses_packages?faces-redirect=true";
    }

    public String goToCoursesPage() {
        return "courses?faces-redirect=true";
    }

    public String goToOptionalCoursesPackageInsertionPage() {
        return "insert_optional_courses_packages?faces-redirect=true";
    }

    public String goToCoursesInsertionPage() {
        return "insert_courses?faces-redirect=true";
    }

    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getResult() {
        if (input == null) {
            return "";
        }

        if (input.toLowerCase().equals("sessionid")) {
            FacesContext fCtx = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fCtx.getExternalContext().getSession(false);

            return "Session ID: " + session.getId();
        }

        return "";
    }
}
