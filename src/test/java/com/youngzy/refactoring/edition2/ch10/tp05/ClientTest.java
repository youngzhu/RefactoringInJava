package com.youngzy.refactoring.edition2.ch10.tp05;

import com.youngzy.refactoring.edition2.ch10.tp05.v02.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    Site siteWithCustomer, siteWithUnknownCustomer;

    @Before
    public void setUp() throws Exception {
        siteWithCustomer = new Site();
        Customer customer = new Customer("王胖子凯旋", "终身制", 9999);
        siteWithCustomer.setCustomer(customer);

        siteWithUnknownCustomer = new Site();
    }

    @Test
    public void clientOneWithKnown() {
        Client client = new Client(siteWithCustomer);

        assertEquals("王胖子凯旋", client.clientOne());
    }

    @Test
    public void clientOneWithUnknown() {
        Client client = new Client(siteWithUnknownCustomer);

        assertEquals("无名氏", client.clientOne());
    }

    @Test
    public void clientTwoWithKnown() {
        Client client = new Client(siteWithCustomer);

        assertEquals("终身制", client.clientTwo());
    }

    @Test
    public void clientTwoWithUnknown() {
        Client client = new Client(siteWithUnknownCustomer);

        assertEquals("基础套餐", client.clientTwo());
    }

    @Test
    public void clientThreeWithKnown() {
        Client client = new Client(siteWithCustomer);

        String newPlan = "新套餐";

        assertEquals(newPlan, client.clientThree(newPlan));
    }

    @Test
    public void clientThreeWithUnknown() {
        Client client = new Client(siteWithUnknownCustomer);

        String newPlan = "新套餐";

        assertEquals(null, client.clientThree(newPlan));
    }

    @Test
    public void clientFourWithKnown() {
        Client client = new Client(siteWithCustomer);

        assertEquals(9999, client.clientFour());
    }

    @Test
    public void clientFourWithUnknown() {
        Client client = new Client(siteWithUnknownCustomer);

        assertEquals(0, client.clientFour());
    }
}