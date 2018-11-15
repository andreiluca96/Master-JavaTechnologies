package com.andrluc.javatech.courseallocation.model;

public class Course extends AbstractModel {
    private String name;
    private String shortName;
    private String id;
    private int year;
    private int semester;
    private String url;
    private Lecturer lecturer;
    private int studyGroupsCount;
    private String optionalPackageName;

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

    public String getOptionalPackageName() {
        return optionalPackageName;
    }

    public void setOptionalPackageName(String optionalPackageName) {
        this.optionalPackageName = optionalPackageName;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", id='" + id + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", url='" + url + '\'' +
                ", lecturer=" + lecturer +
                ", studyGroupsCount=" + studyGroupsCount +
                ", optionalPackageName='" + optionalPackageName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
