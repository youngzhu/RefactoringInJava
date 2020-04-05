package com.youngzy.refactoring.edition2.ch01.v06;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public abstract class StatementDataFactory {

    private static Map<String, Play> PLAYS;

    public static StatementData createStatementData(Invoice invoice, Map<String, Play> plays) {
        StatementData ret = new StatementData();

        PLAYS = plays;

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
    private static EnrichPerformance[] enrichPerformance(Performance[] performances) {
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

    private static double totalAmount(Performance[] performances) {
        double ret = 0;

        for (Performance perf : performances) {
            ret += amountFor(perf);
        }

        return ret;
    }

    private static int totalVolumeCredits(Performance[] performances) {
        int ret = 0;
        for (Performance perf : performances) {
            ret += volumeCreditsFor(perf);
        }
        return ret;
    }


    private static int volumeCreditsFor(Performance perf) {
        int ret = 0;

        ret += Math.max(perf.getAudience() - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(playFor(perf).getType())) {
            ret += Math.floor(perf.getAudience() / 5);
        }

        return ret;
    }

    private static Play playFor(Performance performance) {
        return PLAYS.get(performance.getPlayID());
    }

    private static double amountFor(Performance perf) {
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
