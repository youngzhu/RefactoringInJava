package com.youngzy.refactoring.edition2.ch01.v08;

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

    public String htmlStatement() {
        return renderHtml(StatementDataFactory.createStatementData(invoice, plays));
    }

    private String renderHtml(StatementData data) {
        String ret = "<h1>Statement for " + data.getCustomer() + "</h1>\n";
        ret += "<table>\n";
        ret += "<tr><th>Play</th><th>Seats</th><th>Cost</th></tr>";

        for (EnrichPerformance perf : data.getPerformances()) {

            ret += "<tr><td>" + perf.getPlay().getName() + "</td><td>" + RMB(perf.getAmount())
                        + "</td><td>" + perf.getAudience() + "</td></tr>\n";

        }

        ret += "</table>\n";
        ret += "<p>Amount owed is <em>" + RMB(data.getTotalAmount()) + "</em></p>\n";
        ret += "<p>You earned <em>" + data.getVolumeCredits() + "</em> credits</p>\n";

        return ret;
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