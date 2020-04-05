package com.youngzy.refactoring.edition2.ch01.v08;

public class TragedyCalculator extends PerformanceCalculator {
    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    public double amount() {
        double ret = 40000;
        if (this.performance.getAudience() > 30) {
            ret += 1000 * (this.performance.getAudience() - 30);
        }

        return ret;
    }

}
