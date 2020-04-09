package com.youngzy.refactoring.edition1.ch08.tp01.v00;

public class IntRange {
    private int low, high;

    public IntRange(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public boolean includes(int arg) {
        return arg >= low && arg <= high;
    }

    void grow(int factor) {
        high = high * factor;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
