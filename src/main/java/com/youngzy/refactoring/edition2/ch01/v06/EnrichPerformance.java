package com.youngzy.refactoring.edition2.ch01.v06;

public class EnrichPerformance extends Performance {
    private Play play;
    private double amount;

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
