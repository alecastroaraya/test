package com.fullstacktest.fullstack.service;

import com.fullstacktest.fullstack.model.CountryResult;
import com.fullstacktest.fullstack.model.ResourceAllocator;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    private ResourceAllocator allocator;

    public Service() {
        this.allocator = new ResourceAllocator();
    }

    public List<CountryResult> allocate(int hours, int capacity) {
        return allocator.allocate(hours, capacity);
    }

    public void setAllocator(ResourceAllocator allocator) {
        this.allocator = allocator;
    }
}
