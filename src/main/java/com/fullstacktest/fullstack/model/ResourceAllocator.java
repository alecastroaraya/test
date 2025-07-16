package com.fullstacktest.fullstack.model;

import java.util.*;

public class ResourceAllocator {
    private final List<String> regions = Arrays.asList("New York", "India", "China");

    private final List<Machine> machines = Arrays.asList(
            new Machine("Large", 10, Map.of("New York", 120, "India", 140, "China", 110)),
            new Machine("XLarge", 20, Map.of("New York", 230, "India", 0, "China", 200)),
            new Machine("2XLarge", 40, Map.of("New York", 450, "India", 413, "China", 0)),
            new Machine("4XLarge", 80, Map.of("New York", 774, "India", 890, "China", 670)),
            new Machine("8XLarge", 160, Map.of("New York", 1400, "India", 1300, "China", 1180)),
            new Machine("10XLarge", 320, Map.of("New York", 2820, "India", 2970, "China", 0))
    );

    public List<CountryResult> allocate(int hours, int capacity) {
        List<CountryResult> results = new ArrayList<>();

        for (String region : regions) {
            Combination optimal = findOptimalCombination(region, capacity);

            results.add(new CountryResult(
                    region,
                    "$" + (optimal.totalCost() * hours),
                    optimal.machinesUsed()
            ));
        }

        return results;
    }

    private Combination findOptimalCombination(String region, int targetCapacity) {
        List<Machine> availableMachines = machines.stream()
                .filter(m -> m.getCost(region) > 0)
                .sorted((a, b) -> b.getCapacity() - a.getCapacity())
                .toList();

        List<Combination> validCombinations = new ArrayList<>();
        backtrack(availableMachines, targetCapacity, region, 0, new ArrayList<>(), validCombinations);
        return validCombinations.stream()
                .min(Comparator.comparingInt(Combination::totalCost))
                .orElseThrow(() -> new RuntimeException("No valid combination"));
    }

    private void backtrack(List<Machine> machines, int remaining, String region, int index,
                           List<MachineCount> current, List<Combination> results) {
        if (remaining == 0) {
            int totalCost = current.stream()
                    .mapToInt(mc -> mc.count() * getMachineCost(machines, mc.machineType(), region))
                    .sum();
            results.add(new Combination(new ArrayList<>(current), totalCost));
            return;
        }
        if (index >= machines.size()) return;

        Machine machine = machines.get(index);
        int maxCount = remaining / machine.getCapacity();

        for (int count = maxCount; count >= 0; count--) {
            if (count > 0) {
                current.add(new MachineCount(machine.getName(), count));
            }
            backtrack(machines, remaining - count * machine.getCapacity(),
                    region, index + 1, current, results);
            if (count > 0) {
                current.removeLast();
            }
        }
    }

    private int getMachineCost(List<Machine> machines, String name, String region) {
        return machines.stream()
                .filter(m -> m.getName().equals(name))
                .findFirst()
                .orElseThrow()
                .getCost(region);
    }
}