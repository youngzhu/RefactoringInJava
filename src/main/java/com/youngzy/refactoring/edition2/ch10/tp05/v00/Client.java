package com.youngzy.refactoring.edition2.ch10.tp05.v00;

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

        String customerName;

        if (customer == null) {
            customerName = "无名氏";
        } else {
            customerName = customer.getName();
        }

        return customerName;
    }

    public String clientTwo() {
        Customer customer = site.getCustomer();

        String plan = (customer == null) ? "基础套餐" : customer.getBillingPlan();

        return plan;
    }

    public String clientThree(String newPlan) {
        Customer customer = site.getCustomer();

        String plan = null;
        if (null != customer) {
            customer.setBillingPlan(newPlan);

            plan = customer.getBillingPlan();
        }

        return plan;

    }

    public int clientFour() {
        Customer customer = site.getCustomer();

        return  (null == customer) ? 0 : customer.getPaymentHistory();

    }
}
