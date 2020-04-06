package com.youngzy.refactoring.edition2.ch08.tp02.v00;

public class Account {

    private int daysOverdrawn;
    private AccountType type;
    private double interestRate;

    public Account(int daysOverdrawn, AccountType type, double interestRate) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;
        this.interestRate = interestRate;
    }

    public double getBankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += type.getOverdraftCharge(daysOverdrawn);
        }
        return result;
    }
}
