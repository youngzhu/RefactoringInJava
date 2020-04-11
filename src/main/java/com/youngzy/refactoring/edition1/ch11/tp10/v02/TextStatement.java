package com.youngzy.refactoring.edition1.ch11.tp10.v02;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

public class TextStatement extends Statement {

    public String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle()
                + "\t" + each.getMovie().getCharge(each.getDaysRented()) + "\n";
    }

    public String footerString(Customer customer) {
        String result = "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    public String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

}
