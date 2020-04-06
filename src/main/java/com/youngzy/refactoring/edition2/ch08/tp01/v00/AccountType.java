package com.youngzy.refactoring.edition2.ch08.tp01.v00;

public class AccountType {
    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    private boolean premium;
}
