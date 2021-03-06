package com.andrluc.javatech.courseallocation.model;

public class Lecturer extends AbstractModel {
    private String name;

    public Lecturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
