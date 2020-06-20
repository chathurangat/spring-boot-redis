package com.springbootdev.examples.core.controller;

import com.springbootdev.examples.core.Employee;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Cacheable(cacheNames = "screenCache", key = "#employeeId")
    @GetMapping("/employees/{employee-id}")
    public Employee getEmployee(@PathVariable("employee-id") Long employeeId) {
        System.out.println("==not from cache");
        return Employee.builder()
                .id("10")
                .name("chathuranga")
                .build();
    }
}
