package com.youngzy.refactoring.edition2.ch01.v02;

import java.text.NumberFormat;
import java.util.Map;

public class Statement {
    private Invoice invoice;
    private Map<String, Play> plays;

    public Statement(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() {
        double totalAmount = 0;
        int volumeCredits = 0;
        final NumberFormat format = NumberFormat.getCurrencyInstance();

        String result = "Statement for " + invoice.getCustomer() + "\n";

        for (Performance perf : invoice.getPerformances()) {
            // add volume credits
            volumeCredits += Math.max(perf.getAudience() - 30, 0);
            // add extra credit for every ten comedy attendees
            if ("comedy".equals(playFor(perf).getType())) {
                volumeCredits += Math.floor(perf.getAudience() / 5);
            }

            // print line for this order
            result += "  " + playFor(perf).getName() + ": " + format.format(amountFor(perf) / 100)
                        + " (" + perf.getAudience() + " seats)\n";

            totalAmount += amountFor(perf);

        }

        result += "Amount owed is " + format.format(totalAmount / 100) + "\n";
        result += "You earned " + volumeCredits + " credits\n";

        return result;
    }

    private Play playFor(Performance performance) {
        return plays.get(performance.getPlayID());
    }

    private double amountFor(Performance perf) {
        double ret = 0;

        switch (playFor(perf).getType()) {
            case "tragedy":
                ret = 40000;
                if (perf.getAudience() > 30) {
                    ret += 1000 * (perf.getAudience() - 30);
                }
                break;
            case "comedy":
                ret = 30000;
                if (perf.getAudience() > 20) {
                    ret += 10000 + 500 * (perf.getAudience() - 20);
                }
                ret += 300 * perf.getAudience();
                break;
            default:
                throw new Error("unknown type:" + playFor(perf).getType());
        }
        return ret;
    }

}