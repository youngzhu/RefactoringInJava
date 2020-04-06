package com.youngzy.refactoring.edition2.ch08.tp02.v01;

public class AccountType {
    public AccountType(boolean premium, double interestRate) {
        this.premium = premium;
        this.interestRate = interestRate;
    }

    public double getOverdraftCharge(int daysOverdrawn) {
        if (this.isPremium()) {
            final double baseCharge = 10;
            if (daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (daysOverdrawn - 7) * 0.85;
            }
        } else {
            return daysOverdrawn * 1.75;
        }
    }

    public boolean isPremium() {
        return premium;
    }

    private boolean premium;

    public double getInterestRate() {
        return interestRate;
    }

    private double interestRate;
}
