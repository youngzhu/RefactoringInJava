package com.youngzy.refactoring.edition2.ch06.tp02;

public class FooV1 {
    public int rating(int numberOfLateDeliveries) {
        return numberOfLateDeliveries > 5 ? 2 : 1;
    }

}
