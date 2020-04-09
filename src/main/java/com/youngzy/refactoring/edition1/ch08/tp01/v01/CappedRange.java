package com.youngzy.refactoring.edition1.ch08.tp01.v01;

public class CappedRange extends IntRange {
    private int cap;
    public CappedRange(int low, int high, int cap) {
        super(low, high);
        this.cap = cap;
    }

    @Override
    public int getHigh() {
        return Math.min(super.getHigh(), cap);
    }
}
