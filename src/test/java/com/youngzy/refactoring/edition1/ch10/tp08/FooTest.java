package com.youngzy.refactoring.edition1.ch10.tp08;

import com.youngzy.refactoring.edition1.ch10.tp08.v01.Foo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {


    @Test
    public void getPrice1() {

        Foo foo = new Foo(99, 22);
        assertEquals(108.9, foo.getPrice(), 0.1);
    }

    @Test
    public void getPrice2() {
        Foo foo = new Foo(101, 22);
        assertEquals(222.2, foo.getPrice(), 0.1);
    }

    @Before
    public void setUp() throws Exception {
    }

}