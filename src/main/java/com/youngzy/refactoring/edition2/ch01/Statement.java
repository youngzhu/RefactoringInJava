package com.youngzy.refactoring.edition2.ch01;

import java.util.HashMap;
import java.util.Map;

public class Statement {
    static Invoice invoice;

    public void statement() {
        double totalAmount = 0;
        int volumeCredits = 0;
        String result = "Statement for " + invoice.customer;

        for (Performance perf : invoice.performances) {
//            final Play play = plays[perf.playID];

        }
    }

    public Map<String, Play> loadPlays() {
        Map<String, Play> ret = new HashMap<>();

        return ret;
    }

    private static class Performance {
    }



    private class Invoice {
        String customer;
        Performance[] performances;
    }
}

class Play {

    String name;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
