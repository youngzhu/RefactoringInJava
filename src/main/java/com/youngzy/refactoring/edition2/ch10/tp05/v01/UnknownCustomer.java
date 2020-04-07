package com.youngzy.refactoring.edition2.ch10.tp05.v01;

public class UnknownCustomer extends Customer {

    @Override
    public boolean isUnknown() {
        return true;
    }

    @Override
    public String getName() {
        return "无名氏";
    }
}
