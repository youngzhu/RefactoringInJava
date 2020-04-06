package com.youngzy.refactoring.edition2.ch07.tp05;

import com.youngzy.refactoring.edition2.ch07.tp05.v01.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void getTelephoneNumber() {
        Person person = new Person("王武", "021", "40088888");

        assertEquals("021-40088888", person.getTelephoneNumber());
    }
}