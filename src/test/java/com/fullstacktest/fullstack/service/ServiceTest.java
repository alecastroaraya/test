package com.fullstacktest.fullstack.service;

import com.fullstacktest.fullstack.model.ResourceAllocator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private ResourceAllocator allocator;

    @InjectMocks
    private Service service = new Service();

    @Test
    void allocate_callsAllocator() {
        service.setAllocator(allocator);
        service.allocate(5, 230);
        verify(allocator).allocate(5, 230);
    }
}