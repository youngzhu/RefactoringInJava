package com.youngzy.refactoring.edition1.ch01.v02;

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
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        // 这里看出作者定义实例变量以 _ 开头的好处了
        // 原代码是
//        Enumeration rentals = _rentals.elements();
        Enumeration elements = rentals.elements();

        String result = "Rental Record for " + this.name + "\n";

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // add frequent renter points
            frequentRenterPoints ++;

            // add bonus for a two day new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle()
                        + "\t" + each.getCharge() + "\n";

            totalAmount += each.getCharge();
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
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
