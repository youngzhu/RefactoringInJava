package com.youngzy.refactoring.edition2.ch07.tp02.v01;


import java.util.ArrayList;
import java.util.List;

public class Client {

    public void bar() {
        Person person = new Person("张三");

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course());
        courseList.add(new Course());

        // 看着还不错，但课程的操作有了封装
        person.setCourses(courseList);

        // 但还有另一种方式直接更新课程
        // 这就破坏类封装性
        person.getCourses().add(new Course());
    }
}
