package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03;

import com.alibaba.fastjson.JSONObject;

public class SpeciesDelegate {
    protected Bird bird;

    public SpeciesDelegate(JSONObject data, Bird bird) {
        this.bird = bird;
    }

    public int getAirSpeedVelocity() {
        return 0;
    }

    public String getPlumage() {
        return bird.plumage + " 一般";
    }
}
