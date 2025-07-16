package com.fullstacktest.test.controller;

import com.fullstacktest.test.model.CountryResult;
import com.fullstacktest.test.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/allocate")
    public List<CountryResult> allocate(@RequestParam int hours, @RequestParam int capacity){
        return this.service.allocate(hours, capacity);
    }
}