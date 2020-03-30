package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementTest {

    private Statement stat;

    @Before
    public void setUp() throws Exception {
        stat = new Statement();
    }

    @Test
    public void loadPlays() {
        Map<String, Play> playMap = stat.loadPlays(getClass().getResourceAsStream("/plays.json"));

        Play play = playMap.get("as-like");
        assertEquals("As You Like It", play.getName());
        assertEquals("comedy", play.getType());
    }

    @Test
    public void loadInvoices() {
        List<Invoice> invoiceList = stat.loadInvoices(getClass().getResourceAsStream("/invoices.json"));

        Invoice invoice = invoiceList.get(0);
        assertEquals("BigCo", invoice.getCustomer());

        Performance performance = invoice.getPerformances()[2];
        assertEquals("othello", performance.getPlayID());
        assertEquals(40, performance.getAudience());
    }
}