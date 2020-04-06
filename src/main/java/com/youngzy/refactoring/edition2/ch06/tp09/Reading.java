package com.youngzy.refactoring.edition2.ch06.tp09;

import com.alibaba.fastjson.JSONObject;

public class Reading {
    private String customer;
    private int quantity;
    private int month;
    private int year;

    public double getTaxableCharge() {
        return Math.max(0, this.getBaseCharge() - taxThreshold(this.getYear()));
//        return 0;
    }

    /**
     * 随便写的
     * 返回当年应缴税费
     *
     * @param year
     * @return
     */
    private double taxThreshold(int year) {
        return year * 0.015;
    }

    public double getBaseCharge() {
        return baseRate() * quantity;
    }

    /**
     * 随便写的 当年当月的基本费率
     *
     * @return
     */
    private double baseRate() {
        return (year ^ month ^ 1000) * 0.1;
    }

    public String getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
