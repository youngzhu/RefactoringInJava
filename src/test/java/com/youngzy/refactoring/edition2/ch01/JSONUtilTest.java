package com.youngzy.refactoring.edition2.ch01;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class JSONUtilTest {

    @Test
    public void loadInvoices() {
        List<Invoice> invoiceList = JSONUtil.loadInvoices(getClass().getResourceAsStream("/invoices.json"));

        Invoice invoice = invoiceList.get(0);
        assertEquals("BigCo", invoice.getCustomer());

        Performance performance = invoice.getPerformances()[2];
        assertEquals("othello", performance.getPlayID());
        assertEquals(40, performance.getAudience());
    }

    @Test
    public void loadPlays() {
        Map<String, Play> playMap = JSONUtil.loadPlays(getClass().getResourceAsStream("/plays.json"));

        Play play = playMap.get("as-like");
        assertEquals("As You Like It", play.getName());
        assertEquals("comedy", play.getType());
    }
}