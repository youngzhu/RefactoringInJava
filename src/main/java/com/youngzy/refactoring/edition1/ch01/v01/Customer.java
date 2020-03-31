package com.youngzy.refactoring.edition1.ch01.v01;

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

            double thisAmount = amountFor(each);

            // add frequent renter points
            frequentRenterPoints ++;

            // add bonus for a two day new release rental
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1) {
                frequentRenterPoints ++;
            }

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle()
                        + "\t" + thisAmount + "\n";

            totalAmount += thisAmount;
        }

        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }

    private double amountFor(Rental rental) {
        double ret = 0;

        // determine amounts for each line
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                ret += 2;
                if (rental.getDaysRented() > 2) {
                    ret += (rental.getDaysRented() - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                ret += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDREN:
                ret += 1.5;
                if (rental.getDaysRented() > 3) {
                    ret += (rental.getDaysRented() - 3) * 1.5;
                }
                break;
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
