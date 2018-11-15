package com.andrluc.javatech.courseallocation.model;

public class OptionalCoursesPackage extends AbstractModel {
    private String name;
    private int year;
    private int semester;
    private int coursesCount;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCoursesCount() {
        return coursesCount;
    }

    public void setCoursesCount(int coursesCount) {
        this.coursesCount = coursesCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OptionalCoursesPackage{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", coursesCount=" + coursesCount +
                ", id='" + id + '\'' +
                '}';
    }
}
