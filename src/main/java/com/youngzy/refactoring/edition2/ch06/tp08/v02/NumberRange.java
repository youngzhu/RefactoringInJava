package com.youngzy.refactoring.edition2.ch06.tp08.v02;

public class NumberRange {
    private double min;
    private double max;

    public NumberRange(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public boolean contains(double number) {
        return number >= min && number <= max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
