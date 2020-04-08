package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v02;

import com.alibaba.fastjson.JSONObject;

public class Bird {
    private String name;
    protected String plumage;
    private int airSpeedVelocity;

    private SpeciesDelegate speciesDelegate;

    public Bird(JSONObject rawData) {
        this.name = rawData.getString("name");
        this.plumage = rawData.getString("plumage");

        speciesDelegate = selectDelegate(rawData);
    }

    private SpeciesDelegate selectDelegate(JSONObject rawData) {
        switch (rawData.getString("type")) {
            case "EuropeanSwallow":
                return new EuropeanSwallowDelegate();
            case "AfricanSwallow":
                return new AfricanSwallowDelegate(rawData);
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getPlumage() {
        return plumage + " 一般";
    }

    public int getAirSpeedVelocity() {
        return this.speciesDelegate == null ? 0 : speciesDelegate.getAirSpeedVelocity();
    }
}
