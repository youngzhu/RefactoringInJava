package com.youngzy.refactoring.edition2.ch07.tp02.v00;

import java.util.List;

public class Person {
    private String name;
    private List<Course> courses;

    public Person(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
