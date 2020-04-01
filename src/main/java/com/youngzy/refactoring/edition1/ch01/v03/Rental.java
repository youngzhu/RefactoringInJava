package com.youngzy.refactoring.edition1.ch01.v03;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getFrequentRenterPoints() {
        int ret = 0;

        // add frequent renter points
        ret ++;

        // add bonus for a two day new release rental
        if (movie.getPriceCode() == Movie.NEW_RELEASE
                && daysRented > 1) {
            ret ++;
        }
        return ret;
    }

    public double getCharge() {
        double ret = 0;

        // determine amounts for each line
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                ret += 2;
                if (daysRented > 2) {
                    ret += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                ret += daysRented * 3;
                break;
            case Movie.CHILDREN:
                ret += 1.5;
                if (daysRented > 3) {
                    ret += (daysRented - 3) * 1.5;
                }
                break;
        }

        return ret;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }
}
