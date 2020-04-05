package com.youngzy.refactoring.edition2.ch01.v07;

public class EnrichPerformance extends Performance {
    private Play play;
    private double amount;
    private int volumeCredits;

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

    public int getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(int volumeCredits) {
        this.volumeCredits = volumeCredits;
    }
}
