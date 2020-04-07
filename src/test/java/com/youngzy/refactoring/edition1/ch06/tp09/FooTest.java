package com.youngzy.refactoring.edition1.ch06.tp09;

import com.youngzy.refactoring.edition1.ch06.tp09.v01.Foo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {
    Foo foo;

    @Test
    public void findPersonExist() {
        String[] people = new String[]{
                "王五",
                "张三"
        };

        assertEquals("张三", foo.findPerson(people));
    }

    @Test
    public void findPersonNotExist() {
        String[] people = new String[]{
                "王五",
                "王胖子"
        };

        assertEquals("", foo.findPerson(people));
    }

    @Before
    public void setUp() throws Exception {
        foo = new Foo();
    }
}