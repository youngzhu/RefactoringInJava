package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v00;

import com.alibaba.fastjson.JSONObject;

public class AfricanSwallow extends Bird {
    private int numberOfCoconuts;

    public AfricanSwallow(JSONObject rawData) {
        super(rawData);
        this.numberOfCoconuts = rawData.getInteger("numberOfCoconuts");
    }

    @Override
    public int getAirSpeedVelocity() {
        return 40 - 2 * this.numberOfCoconuts;
    }

}
