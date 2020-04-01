package com.youngzy.refactoring.edition1.ch01;

import com.youngzy.refactoring.edition1.ch01.v04.*;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void statement() {
        Movie movie1 = new Movie("英雄本色", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("佩奇", Movie.CHILDREN);

        Rental rental1 = new Rental(movie1, 5);
        Rental rental2 = new Rental(movie2, 2);

        Customer customer = new Customer("张三");
        customer.addRental(rental1);
        customer.addRental(rental2);

        String statement = customer.statement();
        System.out.println(statement);

        String expected = "Rental Record for 张三\n" +
                "\t英雄本色\t15.0\n" +
                "\t佩奇\t1.5\n" +
                "Amount owed is 16.5\n" +
                "You earned 3 frequent renter points";

        Assert.assertEquals(expected, statement);
    }
}