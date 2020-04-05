package com.youngzy.refactoring.edition2.ch01;

import com.youngzy.refactoring.edition2.ch01.v05.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

public class StatementTest {

    private Statement stat;

    @Before
    public void setUp() throws Exception {
        InputStream invoicesStream = getClass().getResourceAsStream("/invoices.json");
        InputStream playsStream = getClass().getResourceAsStream("/plays.json");

        List<Invoice> invoiceList = JSONUtil.loadInvoices(invoicesStream);
        Invoice invoice = invoiceList.get(0);

        stat = new Statement(invoice, JSONUtil.loadPlays(playsStream));
    }

    @Test
    public void statement() {
        String expected = "Statement for BigCo\n" +
                "  Hamlet: ￥650.00 (55 seats)\n" +
                "  As You Like It: ￥580.00 (35 seats)\n" +
                "  Othello: ￥500.00 (40 seats)\n" +
                "Amount owed is ￥1,730.00\n" +
                "You earned 47 credits\n";

        String result = stat.statement();
        System.out.println(result);

        assertEquals(expected, result);
    }
}