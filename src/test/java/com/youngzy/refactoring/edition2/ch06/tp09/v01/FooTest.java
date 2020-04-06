package com.youngzy.refactoring.edition2.ch06.tp09.v01;

import com.alibaba.fastjson.JSONObject;
import com.youngzy.refactoring.edition2.ch06.tp09.Reading;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FooTest {
    private static final String DATA = "{\n" +
            "  \"customer\": \"ivan\",\n" +
            "  \"quantity\": 10,\n" +
            "  \"month\": 5,\n" +
            "  \"year\": 2020\n" +
            "}";


    @Test
    public void client1() {
        Reading reading = JSONObject.parseObject(DATA, Reading.class);

        assertEquals(1033.01, reading.getBaseCharge(), 0.1);
    }

    /**
     * 随便写的 当年当月的基本费率
     *
     * @param month
     * @param year
     * @return
     */
    private double baseRate(int month, int year) {
        return (year ^ month ^ 1000) * 0.1;
    }

    @Test
    public void client2() {
        Reading reading = JSONObject.parseObject(DATA, Reading.class);

        assertEquals(1002.7, reading.getTaxableCharge(), 0.1);
    }

    @Test
    public void client3() {
        Reading reading = JSONObject.parseObject(DATA, Reading.class);

        double baseChargeAmount = reading.getBaseCharge();

        assertEquals(1033, baseChargeAmount, 0.1);

    }
}