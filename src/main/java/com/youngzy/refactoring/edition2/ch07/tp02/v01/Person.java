package com.youngzy.refactoring.edition2.ch07.tp02.v01;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Course> courses;

    public Person(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        try {
            return (List<Course>) BeanUtils.cloneBean(courses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {

    }
}
