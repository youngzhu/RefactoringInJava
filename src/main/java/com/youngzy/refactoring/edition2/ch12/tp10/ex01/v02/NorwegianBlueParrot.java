package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v02;

import com.alibaba.fastjson.JSONObject;

public class NorwegianBlueParrot extends Bird {

    private int voltage;
    private boolean isNailed;

    public NorwegianBlueParrot(JSONObject rawData) {
        super(rawData);
        this.voltage = rawData.getInteger("voltage");
        this.isNailed = rawData.getBoolean("isNailed");
    }

    @Override
    public String getPlumage() {
        if (this.voltage > 100) {
            return "焦了";
        } else {
            return this.plumage + " 漂亮极了";
        }
    }

    @Override
    public int getAirSpeedVelocity() {
        return isNailed ? 0 : 10 + this.voltage / 10;
    }
}
