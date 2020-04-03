package com.youngzy.refactoring.edition1.ch06.tp01;

import com.youngzy.refactoring.edition1.ch06.tp01.v04.Foo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FooTest {

    private Foo foo;

    @Before
    public void setUp() throws Exception {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1.2));
        orders.add(new Order(8.88));
        foo = new Foo("Adam", orders);
    }

    @Test
    public void printOwing() {
        String expected = "************************\n" +
                "***** Customer Owes ****\n" +
                "************************\n" +
                "name: Adam\n" +
                "amount: 10.08";
        assertEquals(expected, foo.printOwing());
    }

    @Test
    public void printOwingWithParameter() {
        String expected = "************************\n" +
                "***** Customer Owes ****\n" +
                "************************\n" +
                "name: Adam\n" +
                "amount: 89.28";
        assertEquals(expected, foo.printOwing(66));
    }
}