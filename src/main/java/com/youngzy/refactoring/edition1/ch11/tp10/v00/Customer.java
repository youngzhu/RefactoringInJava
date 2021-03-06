package com.youngzy.refactoring.edition1.ch11.tp10.v00;

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
        // 这里看出作者定义实例变量以 _ 开头的好处了
        // 原代码是
//        Enumeration rentals = _rentals.elements();
        Enumeration elements = rentals.elements();

        String result = "Rental Record for " + this.name + "\n";

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle()
                        + "\t" + each.getMovie().getCharge(each.getDaysRented()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        // 这里看出作者定义实例变量以 _ 开头的好处了
        // 原代码是
//        Enumeration rentals = _rentals.elements();
        Enumeration elements = rentals.elements();

        String result = "<H1>Rental Record for <EM>" + this.name + "</EM></H1><P>\n";

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();

            // show figures for this rental
            result += each.getMovie().getTitle()
                    + ": " + each.getMovie().getCharge(each.getDaysRented()) + "<BR>\n";
        }

        // add footer lines
        result += "<P>You owe <EM>" + getTotalCharge() + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getTotalFrequentRenterPoints() + "</EM> frequent renter points<P>";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int ret = 0;

        Enumeration elements = rentals.elements();

        while (elements.hasMoreElements()) {
            Rental each = (Rental) elements.nextElement();
            ret += each.getMovie().getFrequentRenterPoints(each.getDaysRented());
        }

        return ret;
    }

    private double getTotalCharge() {
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
