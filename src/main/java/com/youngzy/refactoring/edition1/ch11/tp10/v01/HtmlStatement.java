package com.youngzy.refactoring.edition1.ch11.tp10.v01;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

import java.util.Enumeration;

public class HtmlStatement extends Statement {
    public String htmlStatement(Customer customer) {
        Enumeration elements = customer.getRentals().elements();

        String result = "<H1>Rental Record for <EM>" + customer.getName() + "</EM></H1><P>\n";

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += each.getMovie().getTitle()
                    + ": " + each.getMovie().getCharge(each.getDaysRented()) + "<BR>\n";
        }

        // add footer lines
        result += "<P>You owe <EM>" + customer.getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + customer.getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";

        return result;
    }
}
