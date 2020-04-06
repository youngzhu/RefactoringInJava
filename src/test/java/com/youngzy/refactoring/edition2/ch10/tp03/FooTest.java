package com.youngzy.refactoring.edition2.ch10.tp03;

import com.youngzy.refactoring.edition2.ch10.tp03.v01.Foo;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void testDead() {
        Foo foo = new Foo();
        Employee employee = new Employee("dead");

        assertEquals(0, foo.getPayAmount(employee), 0);
    }

    @Test
    public void testSeparated() {
        Foo foo = new Foo();
        Employee employee = new Employee("separated");

        assertEquals(888, foo.getPayAmount(employee), 0);
    }

    @Test
    public void testRetired() {
        Foo foo = new Foo();
        Employee employee = new Employee("retired");

        assertEquals(600, foo.getPayAmount(employee), 0);
    }

    @Test
    public void testNormal() {
        Foo foo = new Foo();
        Employee employee = new Employee("normal");

        assertEquals(750, foo.getPayAmount(employee), 0);
    }
}