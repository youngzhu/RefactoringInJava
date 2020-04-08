package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v00;

import com.alibaba.fastjson.JSONObject;

public class EuropeanSwallow extends Bird {

    public EuropeanSwallow(JSONObject rawData) {
        super(rawData);
    }

    @Override
    public int getAirSpeedVelocity() {
        return 35;
    }
}
