package com.youngzy.refactoring.edition2.ch01.v06;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
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

        return renderPlainText(createStatementData(invoice));
    }

    private StatementData createStatementData(Invoice invoice) {
        StatementData ret = new StatementData();

        ret.setCustomer(invoice.getCustomer());
        Performance[] performances = invoice.getPerformances();
        ret.setPerformances(enrichPerformance(performances));
        ret.setTotalAmount(totalAmount(performances));
        ret.setVolumeCredits(totalVolumeCredits(performances));

        return ret;
    }

    /**
     * 将 另外一些必要信息封装到 Performance ，如 Play
     *
     * 为了不改变原对象。这里新建了对象的副本返回。
     * 保持数据不可变性（immutable）
     *
     * @param performances
     * @return
     */
    private EnrichPerformance[] enrichPerformance(Performance[] performances) {
        EnrichPerformance[] ret = new EnrichPerformance[performances.length];

        int i = 0;
        EnrichPerformance dest;
        for (Performance orig : performances) {
            dest = new EnrichPerformance();
            try {
                BeanUtils.copyProperties(dest, orig);
            } catch (Exception e) {
                e.printStackTrace();
            }

            dest.setPlay(playFor(orig));
            dest.setAmount(amountFor(orig));

            ret[i ++] = dest;
        }

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

    private double totalAmount(Performance[] performances) {
        double ret = 0;

        for (Performance perf : performances) {
            ret += amountFor(perf);
        }

        return ret;
    }

    private int totalVolumeCredits(Performance[] performances) {
        int ret = 0;
        for (Performance perf : performances) {
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