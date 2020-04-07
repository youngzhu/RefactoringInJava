package com.youngzy.refactoring.edition1.ch06.tp09.v00;

public class Foo {
    public String findPerson(String[] people) {

        for (int i = 0; i < people.length; i++) {
            if ("张三".equals(people[i])) {
                return "张三";
            }
            if ("李四".equals(people[i])) {
                return "李四";
            }
            if ("王二".equals(people[i])) {
                return "王二";
            }
        }

        return "";
    }
}
