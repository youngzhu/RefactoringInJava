package com.youngzy.refactoring.edition1.ch11.tp10.v02;

import com.youngzy.refactoring.edition1.ch11.tp10.Rental;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String statement() {
        return new TextStatement().statement(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().statement(this);
    }

    public int getTotalFrequentRenterPoints() {
        int ret = 0;

        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            ret += each.getMovie().getFrequentRenterPoints(each.getDaysRented());
        }

        return ret;
    }

    public double getTotalCharge() {
        double ret = 0;

        Enumeration elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            ret += each.getMovie().getCharge(each.getDaysRented());
        }

        return ret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getRentals() {
        return rentals;
    }

    public void setRentals(Vector rentals) {
        this.rentals = rentals;
    }
}
