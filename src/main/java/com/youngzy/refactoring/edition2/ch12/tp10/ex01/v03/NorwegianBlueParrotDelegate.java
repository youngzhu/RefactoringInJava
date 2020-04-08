package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03;

import com.alibaba.fastjson.JSONObject;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {

    private int voltage;
    private boolean isNailed;

    public NorwegianBlueParrotDelegate(JSONObject rawData, Bird bird) {
        super(rawData, bird);

        this.voltage = rawData.getInteger("voltage");
        this.isNailed = rawData.getBoolean("isNailed");
    }

    public String getPlumage() {
        if (this.voltage > 100) {
            return "焦了";
        } else {
            return bird.plumage + " 漂亮极了";
        }
    }

    @Override
    public int getAirSpeedVelocity() {
        return isNailed ? 0 : 10 + this.voltage / 10;
    }
}
