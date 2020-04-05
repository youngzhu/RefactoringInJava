package com.youngzy.refactoring.edition2.ch01;

import com.youngzy.refactoring.edition2.ch01.v08.*;
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

    @Test
    public void htmlStatement() {
        String expected = "<h1>Statement for BigCo</h1>\n" +
                "<table>\n" +
                "<tr><th>Play</th><th>Seats</th><th>Cost</th></tr><tr><td>Hamlet</td><td>￥650.00</td><td>55</td></tr>\n" +
                "<tr><td>As You Like It</td><td>￥580.00</td><td>35</td></tr>\n" +
                "<tr><td>Othello</td><td>￥500.00</td><td>40</td></tr>\n" +
                "</table>\n" +
                "<p>Amount owed is <em>￥1,730.00</em></p>\n" +
                "<p>You earned <em>47</em> credits</p>\n";

        String actual = stat.htmlStatement();
        System.out.println(actual);

        assertEquals(expected, actual);
    }

}