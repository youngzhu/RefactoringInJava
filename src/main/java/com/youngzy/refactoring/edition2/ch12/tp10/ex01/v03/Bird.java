package com.youngzy.refactoring.edition2.ch12.tp10.ex01.v03;

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
                return new EuropeanSwallowDelegate(rawData, this);
            case "AfricanSwallow":
                return new AfricanSwallowDelegate(rawData, this);
            case "NorwegianBlueParrot":
                return new NorwegianBlueParrotDelegate(rawData, this);
            default:
                return new SpeciesDelegate(rawData, this);
        }
    }

    public String getName() {
        return name;
    }

    public String getPlumage() {
        return this.speciesDelegate == null ? this.plumage + " 一般" : speciesDelegate.getPlumage();
    }

    public int getAirSpeedVelocity() {
        return this.speciesDelegate == null ? 0 : speciesDelegate.getAirSpeedVelocity();
    }
}
