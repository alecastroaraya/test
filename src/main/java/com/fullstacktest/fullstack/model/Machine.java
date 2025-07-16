package com.fullstacktest.fullstack.model;

import java.util.Map;

public class Machine {
    private final String name;
    private final int capacity;
    private final Map<String, Integer> costPerCountry;

    public Machine(String name, int capacity, Map<String, Integer> costPerCountry) {
        this.name = name;
        this.capacity = capacity;
        this.costPerCountry = costPerCountry;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCost(String country) {
        return this.costPerCountry.get(country);
    }

}
