package com.youngzy.refactoring.edition2.ch01;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatementTest {

    private Statement01 stat;

    @Before
    public void setUp() throws Exception {
        InputStream invoicesStream = getClass().getResourceAsStream("/invoices.json");
        InputStream playsStream = getClass().getResourceAsStream("/plays.json");

        List<Invoice> invoiceList = JSONUtil.loadInvoices(invoicesStream);
        Invoice invoice = invoiceList.get(0);

        stat = new Statement01(invoice, JSONUtil.loadPlays(playsStream));
    }

    @Test
    public void statement() {
        String result = stat.statement();
        System.out.println(result);
    }
}