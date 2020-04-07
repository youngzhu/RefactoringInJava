package com.youngzy.refactoring.edition2.ch10.tp05.v02;

/**
 * 所有的客户端都需要判断 customer 是否为 null
 * 这时就可以引入一个特别对象了：UnknownCustomer
 */
public class Client {

    private Site site;

    public Client(Site site) {
        this.site = site;
    }

    public String clientOne() {
        Customer customer = site.getCustomer();

        return customer.getName();
    }

    public String clientTwo() {
        Customer customer = site.getCustomer();

        return customer.getBillingPlan();
    }

    public String clientThree(String newPlan) {
        Customer customer = site.getCustomer();

        customer.setBillingPlan(newPlan);

        return customer.getBillingPlan();

    }

    public int clientFour() {
        Customer customer = site.getCustomer();

        return customer.getPaymentHistory();

    }
}
