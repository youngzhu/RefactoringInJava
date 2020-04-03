package com.youngzy.refactoring.edition1.ch06.tp01.v01;

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
        double outstanding = 0;

        // print banner
        ret.append(printBanner());

        // calculate outstanding
        while (iterator.hasNext()) {
            Order each = iterator.next();
            outstanding += each.getAmount();
        }

        // print details
        ret.append("name: " + name).append("\n");
        ret.append("amount: " + outstanding);
        System.out.println(ret);
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
