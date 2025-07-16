package com.fullstacktest.fullstack.model;

import java.util.List;

public class CountryResult {
    private String region;
    private String totalCost;
    private List<MachineCount> machines;

    public CountryResult(String region, String totalCost, List<MachineCount> machines) {
        this.region = region;
        this.totalCost = totalCost;
        this.machines = machines;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public List<MachineCount> getMachines() {
        return machines;
    }

    public void setMachines(List<MachineCount> machines) {
        this.machines = machines;
    }
}
