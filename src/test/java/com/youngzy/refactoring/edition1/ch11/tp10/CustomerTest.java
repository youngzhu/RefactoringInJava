package com.youngzy.refactoring.edition1.ch11.tp10;

import com.youngzy.refactoring.edition1.ch11.tp10.v02.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    Customer customer;

    @Test
    public void statement() {
        String statement = customer.statement();
        System.out.println(statement);

        String expected = "Rental Record for 张三\n" +
                "\t英雄本色\t15.0\n" +
                "\t佩奇\t1.5\n" +
                "\t暗战\t44.0\n" +
                "Amount owed is 60.5\n" +
                "You earned 4 frequent renter points";

        Assert.assertEquals(expected, statement);
    }

    @Test
    public void htmlStatement() {
        String statement = customer.htmlStatement();
        System.out.println(statement);

        String expected = "<H1>Rental Record for <EM>张三</EM></H1><P>\n" +
                "英雄本色: 15.0<BR>\n" +
                "佩奇: 1.5<BR>\n" +
                "暗战: 44.0<BR>\n" +
                "<P>You owe <EM>60.5</EM><P>\n" +
                "On this rental you earned <EM>4</EM> frequent renter points<P>";

        Assert.assertEquals(expected, statement);
    }

    @Before
    public void setUp() throws Exception {
        Movie movie1 = new Movie("英雄本色", Movie.NEW_RELEASE);
        Movie movie2 = new Movie("佩奇", Movie.CHILDREN);
        Movie movie3 = new Movie("暗战", Movie.REGULAR);

        Rental rental1 = new Rental(movie1, 5);
        Rental rental2 = new Rental(movie2, 2);
        Rental rental3 = new Rental(movie3, 30);

        customer = new Customer("张三");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
    }
}