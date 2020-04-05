package com.youngzy.refactoring.edition2.ch01.v06;

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

        return renderPlainText(StatementDataFactory.createStatementData(invoice, plays));
    }

    private String renderPlainText(StatementData data) {
        String ret = "Statement for " + data.getCustomer() + "\n";

        for (EnrichPerformance perf : data.getPerformances()) {

            // print line for this order
            ret += "  " + perf.getPlay().getName() + ": " + RMB(perf.getAmount())
                        + " (" + perf.getAudience() + " seats)\n";

        }

        ret += "Amount owed is " + RMB(data.getTotalAmount()) + "\n";
        ret += "You earned " + data.getVolumeCredits() + " credits\n";

        return ret;
    }


    private String RMB(double amount) {
        final NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);

        return format.format(amount / 100);
    }

}