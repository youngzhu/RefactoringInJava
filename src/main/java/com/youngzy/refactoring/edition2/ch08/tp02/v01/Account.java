package com.youngzy.refactoring.edition2.ch08.tp02.v01;

public class Account {

    private int daysOverdrawn;
    private AccountType type;
    private double interestRate;

    public Account(int daysOverdrawn, AccountType type, double interestRate) {
        this.daysOverdrawn = daysOverdrawn;
        this.type = type;

        // 防止部分账户有特殊优惠，先观察一段时间
        // 加个 断言 或 日志
        assert (interestRate == type.getInterestRate());
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
