package com.youngzy.refactoring.edition1.ch11.tp10.v01;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

import java.util.Enumeration;

public class TextStatement extends Statement {
    public String statement(Customer customer) {
        Enumeration elements = customer.getRentals().elements();

        String result = "Rental Record for " + customer.getName() + "\n";

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle()
                    + "\t" + each.getMovie().getCharge(each.getDaysRented()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + customer.getTotalCharge() + "\n";
        result += "You earned " + customer.getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

}
