package com.youngzy.refactoring.edition2.ch01.v08;

public class StatementData {

    private String customer;
    private EnrichPerformance[] performances;
    private double totalAmount;
    private int volumeCredits;

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setPerformances(EnrichPerformance[] performances) {
        this.performances = performances;
    }

    public EnrichPerformance[] getPerformances() {
        return performances;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }

    public void setVolumeCredits(int volumeCredits) {
        this.volumeCredits = volumeCredits;
    }
}
