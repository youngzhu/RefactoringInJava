package com.youngzy.refactoring.edition2.ch10.tp05.v02;

public class UnknownCustomer extends Customer {

    @Override
    public boolean isUnknown() {
        return true;
    }

    @Override
    public String getName() {
        return "无名氏";
    }

    @Override
    public String getBillingPlan() {
        return "基础套餐";
    }

    @Override
    public void setBillingPlan(String billingPlan) {
    }
}
