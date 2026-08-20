package com.bonginkosi.salaryservice.controller;

import com.bonginkosi.salaryservice.dto.SalaryDto;
import com.bonginkosi.salaryservice.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employees_salary")
public class salaryController {

    private final SalaryService salaryService;
    @Autowired
    public salaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    //Method to create a Salary record for an employee
    @PostMapping
    public SalaryDto createSalary(@RequestBody SalaryDto salaryDto) {
        return salaryService.createSalary(salaryDto);
    }

    // Patch method to update a salary record
    @PatchMapping("/{id}")
    public SalaryDto updateSalary(@PathVariable Integer id, @RequestBody SalaryDto salaryDto) {
        return salaryService.updateSalary(id,salaryDto);
    }




}
