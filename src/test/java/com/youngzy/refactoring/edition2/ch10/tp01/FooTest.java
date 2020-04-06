package com.youngzy.refactoring.edition2.ch10.tp01;

import com.youngzy.refactoring.edition2.ch10.tp01.v01.Foo;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void getTotalAmount() {
        Foo foo = new Foo(1000);

        assertEquals(950, foo.getTotalAmount(new Date(88888888)), 0);
    }
}