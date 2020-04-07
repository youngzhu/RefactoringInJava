package com.youngzy.refactoring.edition2.ch10.tp05.v01;

/**
 * 所有的客户端都需要判断 customer 是否为 null
 * 这时就可以引入一个特别对象了：UnknownCustomer
 */
public class Client {

    private Site site;

    public Client(Site site) {
        this.site = site;
    }

    private boolean isUnknown(Customer customer) {
        return customer instanceof UnknownCustomer
                || null == customer;
    }

    public String clientOne() {
        Customer customer = site.getCustomer();

        String customerName;

        if (isUnknown(customer)) {
            customerName = "无名氏";
        } else {
            customerName = customer.getName();
        }

        return customerName;
    }

    public String clientTwo() {
        Customer customer = site.getCustomer();

        String plan = isUnknown(customer) ? "基础套餐" : customer.getBillingPlan();

        return plan;
    }

    public String clientThree(String newPlan) {
        Customer customer = site.getCustomer();

        String plan = null;
        if (! isUnknown(customer)) {
            customer.setBillingPlan(newPlan);

            plan = customer.getBillingPlan();
        }

        return plan;

    }

    public int clientFour() {
        Customer customer = site.getCustomer();

        return  isUnknown(customer) ? 0 : customer.getPaymentHistory();

    }
}
