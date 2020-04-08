package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03;

import com.alibaba.fastjson.JSONObject;

public class EuropeanSwallowDelegate extends SpeciesDelegate {

    public EuropeanSwallowDelegate(JSONObject data, Bird bird) {
        super(data, bird);
    }

    public int getAirSpeedVelocity() {
        return 35;
    }
}
