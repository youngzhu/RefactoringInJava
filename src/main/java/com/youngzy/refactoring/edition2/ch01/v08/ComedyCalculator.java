package com.youngzy.refactoring.edition2.ch01.v08;

public class ComedyCalculator extends PerformanceCalculator {
    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    public double amount() {
        double ret = 30000;
        if (this.performance.getAudience() > 20) {
            ret += 10000 + 500 * (this.performance.getAudience() - 20);
        }
        ret += 300 * this.performance.getAudience();
        return ret;
    }

    public int volumeCredits() {
        int ret = super.volumeCredits();

        ret += Math.floor(this.performance.getAudience() / 5);

        return ret;
    }


}
