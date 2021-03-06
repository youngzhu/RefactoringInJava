package com.youngzy.refactoring.edition2.ch06.tp01.v03;

import com.youngzy.refactoring.edition2.ch06.tp01.Invoice;
import com.youngzy.refactoring.edition2.ch06.tp01.Order;

import java.util.Date;

public class Foo {
    /**
     * 加 返回值 为了方便测试
     *
     * @param invoice
     * @return
     */
    public String printOwing(Invoice invoice) {
        StringBuffer ret = new StringBuffer();

        ret.append(printBanner());

        final double outstanding = getOutstanding(invoice);

        updateDueDate(invoice);

        ret.append(printDetails(invoice, outstanding));

        return ret.toString();
    }

    private double getOutstanding(Invoice invoice) {
        // calculate outstanding
        double ret = 0;
        for (Order o : invoice.getOrders()) {
            ret += o.getAmount();
        }
        return ret;
    }

    private void updateDueDate(Invoice invoice) {
        // update due date
        Date dueDate = invoice.getDueDate();
        Date newDate = new Date(dueDate.getYear(), dueDate.getMonth(), dueDate.getDate() + 30);
        invoice.setDueDate(newDate);
    }

    private String printDetails(Invoice invoice, double outstanding) {
        StringBuffer ret = new StringBuffer();
        // print details
        ret.append("name: " + invoice.getCustomer()).append("\n");
        ret.append("amount: " + outstanding).append("\n");
        ret.append("due: " + invoice.getDueDate().toLocaleString()).append("\n");
        return ret.toString();
    }

    private String printBanner() {
        StringBuffer ret = new StringBuffer();
        ret.append("************************\n");
        ret.append("*****Customer Owes******\n");
        ret.append("************************\n");
        return ret.toString();
    }
}
