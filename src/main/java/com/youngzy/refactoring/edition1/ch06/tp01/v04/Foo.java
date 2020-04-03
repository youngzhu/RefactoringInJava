package com.youngzy.refactoring.edition1.ch06.tp01.v04;

import com.youngzy.refactoring.edition1.ch06.tp01.Order;

import java.util.Iterator;
import java.util.List;

public class Foo {
    private String name;
    private List<Order> orders;

    public Foo(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    /**
     * 返回值 是为了方便测试
     */
    public String printOwing() {
        StringBuilder ret = new StringBuilder();

        Iterator<Order> iterator = orders.iterator();
        double outstanding = getOutstanding();

        // print banner
        ret.append(printBanner());

        // print details
        ret.append(printDetails(outstanding));

        System.out.println(ret);
        return ret.toString();
    }

    /**
     * 新增一个方法，为 V04 做准备
     */
    public String printOwing(double previousAmount) {
        StringBuilder ret = new StringBuilder();

        Iterator<Order> iterator = orders.iterator();
        double outstanding = getOutstanding(previousAmount * 1.2);

        // print banner
        ret.append(printBanner());

        // print details
        ret.append(printDetails(outstanding));

        return ret.toString();
    }

    private double getOutstanding(double initVal) {
        double ret = initVal;

        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order each = iterator.next();
            ret += each.getAmount();
        }

        return ret;
    }

    private double getOutstanding() {
        double ret = 0;

        Iterator<Order> iterator = orders.iterator();

        while (iterator.hasNext()) {
            Order each = iterator.next();
            ret += each.getAmount();
        }

        return ret;
    }

    private String printDetails(double outstanding) {
        StringBuilder ret = new StringBuilder();
        ret.append("name: " + name).append("\n");
        ret.append("amount: " + outstanding);
        return ret.toString();
    }

    private String printBanner() {
        StringBuilder ret = new StringBuilder();
        ret.append("************************\n")
            .append("***** Customer Owes ****\n")
            .append("************************\n");

        return ret.toString();
    }
}
