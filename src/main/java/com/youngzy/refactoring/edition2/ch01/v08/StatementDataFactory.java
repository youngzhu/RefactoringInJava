package com.youngzy.refactoring.edition2.ch01.v08;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public abstract class StatementDataFactory {

    private static Map<String, Play> PLAYS;

    public static StatementData createStatementData(Invoice invoice, Map<String, Play> plays) {
        StatementData ret = new StatementData();

        PLAYS = plays;

        ret.setCustomer(invoice.getCustomer());

        EnrichPerformance[] performances = enrichPerformance(invoice.getPerformances());
        ret.setPerformances(performances);

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
        PerformanceCalculator calculator;
        for (Performance orig : performances) {
            dest = new EnrichPerformance();
            try {
                BeanUtils.copyProperties(dest, orig);
            } catch (Exception e) {
                e.printStackTrace();
            }

            calculator = createPerformanceCalculator(orig, playFor(orig));
            dest.setPlay(calculator.getPlay());
            dest.setAmount(calculator.amount());
            dest.setVolumeCredits(calculator.volumeCredits());

            ret[i ++] = dest;
        }

        return ret;
    }

    private static PerformanceCalculator createPerformanceCalculator(Performance performance, Play play) {
        switch (play.getType()) {
            case "tragedy":
                return new TragedyCalculator(performance, play);
            case "comedy":
                return new ComedyCalculator(performance, play);
            default:
                throw new Error("Unknown type:" + play.getType());
        }
    }

    private static double totalAmount(EnrichPerformance[] performances) {
        double ret = 0;

        for (EnrichPerformance perf : performances) {
            ret += perf.getAmount();
        }

        return ret;
    }

    private static int totalVolumeCredits(EnrichPerformance[] performances) {
        int ret = 0;
        for (EnrichPerformance perf : performances) {
            ret += perf.getVolumeCredits();
        }
        return ret;
    }

    private static Play playFor(Performance performance) {
        return PLAYS.get(performance.getPlayID());
    }

}
