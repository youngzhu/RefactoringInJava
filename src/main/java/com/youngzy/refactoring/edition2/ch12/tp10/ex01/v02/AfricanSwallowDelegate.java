package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v02;

import com.alibaba.fastjson.JSONObject;

public class AfricanSwallowDelegate extends SpeciesDelegate {
    private int numberOfCoconuts;

    public AfricanSwallowDelegate(JSONObject rawData) {
        this.numberOfCoconuts = rawData.getInteger("numberOfCoconuts");
    }

    public int getAirSpeedVelocity() {
        return 40 - 2 * this.numberOfCoconuts;
    }

}
