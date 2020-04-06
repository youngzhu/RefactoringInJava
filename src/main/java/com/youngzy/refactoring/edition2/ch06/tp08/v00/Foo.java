package com.youngzy.refactoring.edition2.ch06.tp08.v00;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class Foo {
    public boolean readingOutsideRange(Iterator<Object> data, double max, double min) {

        while (data.hasNext()) {
            Map<String, Object> map = (Map<String, Object>) data.next();

            double temp = ((BigDecimal) map.get("temp")).doubleValue();

            if (temp < min || temp > max) {
                return true;
            }
        }

        return false;
    }
}
