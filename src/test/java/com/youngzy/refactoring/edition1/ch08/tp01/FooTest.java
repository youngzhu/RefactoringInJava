package com.youngzy.refactoring.edition1.ch08.tp01;

import com.youngzy.refactoring.edition1.ch08.tp01.v01.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void intRangeInclude() {
        IntRange intRange = new IntRange(0, 10);

        assertTrue(intRange.includes(8));
    }

    @Test
    public void intRangeNotInclude() {
        IntRange intRange = new IntRange(0, 10);

        assertFalse(intRange.includes(11));
    }

    @Test
    public void cappedRangeInclude() {
        CappedRange cappedRange = new CappedRange(0, 10, 8);

        assertTrue(cappedRange.includes(8));
    }

    @Test
    public void cappedRangeNotInclude() {
        CappedRange cappedRange = new CappedRange(0, 10, 8);

        assertFalse(cappedRange.includes(9));
    }

}