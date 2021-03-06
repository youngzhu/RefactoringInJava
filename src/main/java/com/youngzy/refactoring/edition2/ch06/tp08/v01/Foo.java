package com.youngzy.refactoring.edition2.ch06.tp08.v01;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class Foo {
    public boolean readingOutsideRange(Iterator<Object> data, NumberRange range) {

        while (data.hasNext()) {
            Map<String, Object> map = (Map<String, Object>) data.next();

            double temp = ((BigDecimal) map.get("temp")).doubleValue();

            if (temp < range.getMin() || temp > range.getMax()) {
                return true;
            }
        }

        return false;
    }
}
