package com.youngzy.refactoring.edition2.ch08.tp01.v00;

public class Account {

    private int daysOverdrawn;
    private AccountType type;

    public Account(int daysOverdrawn, AccountType type) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += this.getOverdraftCharge();
        }
        return result;
    }

    private double getOverdraftCharge() {
        if (type.isPremium()) {
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
}
