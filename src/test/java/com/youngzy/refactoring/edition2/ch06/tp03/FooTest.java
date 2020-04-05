package com.youngzy.refactoring.edition2.ch06.tp03;

import com.youngzy.refactoring.edition2.ch06.tp03.v01.Foo;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void price() {
        Foo foo = new Foo();
        double actual = foo.price(50000, 1.5);
        double expected = 71387.5;

        assertEquals(expected, actual, 0);
    }
}