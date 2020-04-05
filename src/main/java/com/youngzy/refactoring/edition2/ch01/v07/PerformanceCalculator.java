package com.youngzy.refactoring.edition2.ch01.v07;

public class PerformanceCalculator {
    private Performance performance;
    private Play play;

    public PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public int volumeCredits() {
        int ret = 0;

        ret += Math.max(this.performance.getAudience() - 30, 0);
        // add extra credit for every ten comedy attendees
        if ("comedy".equals(this.play.getType())) {
            ret += Math.floor(this.performance.getAudience() / 5);
        }

        return ret;
    }

    public double amount() {
        double ret = 0;

        switch (this.play.getType()) {
            case "tragedy":
                ret = 40000;
                if (this.performance.getAudience() > 30) {
                    ret += 1000 * (this.performance.getAudience() - 30);
                }
                break;
            case "comedy":
                ret = 30000;
                if (this.performance.getAudience() > 20) {
                    ret += 10000 + 500 * (this.performance.getAudience() - 20);
                }
                ret += 300 * this.performance.getAudience();
                break;
            default:
                throw new Error("unknown type:" + this.play.getType());
        }
        return ret;
    }

    public Performance getPerformance() {
        return performance;
    }

    public Play getPlay() {
        return play;
    }
}
