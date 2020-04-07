package com.youngzy.refactoring.edition1.ch06.tp09.v01;

import java.util.Arrays;
import java.util.List;

public class Foo {
    public String findPerson(String[] people) {

        List<String> candidates = Arrays.asList(new String[]{
                "张三", "李四", "王二"
        });

        for (int i = 0; i < people.length; i++) {
            if (candidates.contains(people[i])) {
                return people[i];
            }
        }

        return "";
    }
}
