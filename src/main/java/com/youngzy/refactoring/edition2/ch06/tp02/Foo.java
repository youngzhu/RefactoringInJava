package com.youngzy.refactoring.edition2.ch06.tp02;

public class Foo {
    public int rating(int numberOfLateDeliveries) {
        return moreThanFiveLateDeliveries(numberOfLateDeliveries) ? 2 : 1;
    }

    private boolean moreThanFiveLateDeliveries(int numberOfLateDeliveries) {
        return numberOfLateDeliveries > 5;
    }
}
