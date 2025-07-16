package com.fullstacktest.fullstack.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResourceAllocatorTest {
    private final ResourceAllocator allocator = new ResourceAllocator();

    @Test
    void allocate_validInput_returnsOptimalCombination() {
        List<CountryResult> results = allocator.allocate(1, 1150);

        CountryResult nyResult = results.getFirst();
        assertEquals("New York", nyResult.getRegion());
        assertEquals("$10150", nyResult.getTotalCost());
        assertMachineCount(nyResult.getMachines(), "8XLarge", 7);
    }

    @Test
    void allocate_invalidInput_throwsError() {
        assertThrows(RuntimeException.class, () -> allocator.allocate(-1,-1));
    }

    private void assertMachineCount(List<MachineCount> machines, String name, int expectedCount) {
        assertEquals(expectedCount, machines.stream()
                .filter(m -> m.machineType().equals(name))
                .findFirst()
                .orElseThrow()
                .count());
    }
}
