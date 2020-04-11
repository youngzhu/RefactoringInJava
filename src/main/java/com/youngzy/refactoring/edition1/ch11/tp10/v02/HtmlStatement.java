package com.youngzy.refactoring.edition1.ch11.tp10.v02;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

public class HtmlStatement extends Statement {

    @Override
    public String eachRentalString(Rental each) {
        return each.getMovie().getTitle()
                + ": " + each.getMovie().getCharge(each.getDaysRented()) + "<BR>\n";
    }

    @Override
    public String footerString(Customer customer) {
        String result = "<P>You owe <EM>" + customer.getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + customer.getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";
        return result;
    }

    @Override
    protected String headerString(Customer customer) {
        return "<H1>Rental Record for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
