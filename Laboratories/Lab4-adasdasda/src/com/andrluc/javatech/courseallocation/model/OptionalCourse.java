package com.andrluc.javatech.courseallocation.model;

public class OptionalCourse extends Course {
    private String url;
    private Lecturer lecturer;
    private int studyGroupsCount;
    private OptionalCoursesPackage optionalPackage;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public int getStudyGroupsCount() {
        return studyGroupsCount;
    }

    public void setStudyGroupsCount(int studyGroupsCount) {
        this.studyGroupsCount = studyGroupsCount;
    }

    public OptionalCoursesPackage getOptionalPackage() {
        return optionalPackage;
    }

    public void setOptionalPackage(OptionalCoursesPackage optionalPackage) {
        this.optionalPackage = optionalPackage;
    }
}
