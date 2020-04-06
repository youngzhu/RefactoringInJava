package com.youngzy.refactoring.edition2.ch06.tp09.v00;

import com.alibaba.fastjson.JSONObject;
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
        final JSONObject obj = JSONObject.parseObject(DATA);

        int quantity = obj.getInteger("quantity");
        int month = obj.getInteger("month");
        int year = obj.getInteger("year");

        double baseCharge = baseRate(month, year) * quantity;

        assertEquals(1033.01, baseCharge, 0.1);

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
        final JSONObject obj = JSONObject.parseObject(DATA);

        int quantity = obj.getInteger("quantity");
        int month = obj.getInteger("month");
        int year = obj.getInteger("year");

        final double baseCharge = baseRate(month, year) * quantity;

        double taxableCharge = Math.max(0, baseCharge - taxThreshold(year));

        assertEquals(1002.7, taxableCharge, 0.1);

    }

    /**
     * 随便写的
     * 返回当年应缴税费
     *
     * @param year
     * @return
     */
    private double taxThreshold(int year) {
        return year * 0.015;
    }

    @Test
    public void client3() {
        final JSONObject obj = JSONObject.parseObject(DATA);

        double baseChargeAmount = calculateBaseCharge(obj);

        assertEquals(1033, baseChargeAmount, 0.1);

    }

    private double calculateBaseCharge(JSONObject obj) {
        int quantity = obj.getInteger("quantity");
        int month = obj.getInteger("month");
        int year = obj.getInteger("year");

        return baseRate(month, year) * quantity;
    }
}