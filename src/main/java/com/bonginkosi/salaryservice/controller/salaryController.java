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


    @PostMapping
    public SalaryDto createSalary(@RequestBody SalaryDto salaryDto) {
        return salaryService.createSalary(salaryDto);
    }


}
