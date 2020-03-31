package com.youngzy.refactoring.edition1.ch01.v02;

public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
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
