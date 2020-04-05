package com.youngzy.refactoring.edition2.ch06.tp01;

import com.youngzy.refactoring.edition2.ch06.tp01.v03.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FooTest {

    Foo foo;
    Invoice invoice;

    @Before
    public void setUp() throws Exception {
        Order[] orders = new Order[] {
                new Order(100),
                new Order(89)
        };
        Date dueDate = new Date(2020 - 1900, 2, 1);
        invoice = new Invoice("Jacky Ma", orders, dueDate);
        foo = new Foo();
    }

    @Test
    public void printOwing() {
        String expected = "************************\n" +
                "*****Customer Owes******\n" +
                "************************\n" +
                "name: Jacky Ma\n" +
                "amount: 189.0\n" +
                "due: 2020-3-31 0:00:00\n";
        String actual = foo.printOwing(invoice);

        System.out.println(actual);

        assertEquals(expected, actual);
    }
}