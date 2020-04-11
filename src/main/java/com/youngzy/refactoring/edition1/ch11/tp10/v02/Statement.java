package com.youngzy.refactoring.edition1.ch11.tp10.v02;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

import java.util.Enumeration;

public abstract class Statement {
    public String statement(Customer customer) {
        Enumeration elements = customer.getRentals().elements();

        String result = headerString(customer);

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += eachRentalString(each);
        }

        // add footer lines
        result += footerString(customer);

        return result;
    }

    public abstract String eachRentalString(Rental each);

    public abstract String footerString(Customer customer);

    protected abstract String headerString(Customer customer);
}
