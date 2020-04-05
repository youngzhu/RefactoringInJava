package com.youngzy.refactoring.edition2.ch01.v05;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class Statement {
    private Invoice invoice;
    private Map<String, Play> plays;

    public Statement(Invoice invoice, Map<String, Play> plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() {

        String result = "Statement for " + invoice.getCustomer() + "\n";

        for (Performance perf : invoice.getPerformances()) {

            // print line for this order
            result += "  " + playFor(perf).getName() + ": " + RMB(amountFor(perf))
                        + " (" + perf.getAudience() + " seats)\n";

        }

        result += "Amount owed is " + RMB(totalAmount()) + "\n";
        result += "You earned " + totalVolumeCredits() + " credits\n";

        return result;
    }

    private double totalAmount() {
        double ret = 0;

        for (Performance perf : invoice.getPerformances()) {
            ret += amountFor(perf);
        }

        return ret;
    }

    private int totalVolumeCredits() {
        int ret = 0;
        for (Performance perf : invoice.getPerformances()) {
            ret += volumeCreditsFor(perf);
        }
        return ret;
    }

    private String RMB(double amount) {
        final NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);

        return format.format(amount / 100);
    }

    private int volumeCreditsFor(Performance perf) {
        int ret = 0;

        ret += Math.max(perf.getAudience() - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(playFor(perf).getType())) {
            ret += Math.floor(perf.getAudience() / 5);
        }

        return ret;
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