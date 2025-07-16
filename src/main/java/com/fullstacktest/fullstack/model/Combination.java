package com.fullstacktest.fullstack.model;

import java.util.List;

public record Combination(List<MachineCount> machinesUsed, int totalCost) {
}