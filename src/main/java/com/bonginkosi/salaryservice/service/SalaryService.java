package com.bonginkosi.salaryservice.service;

import com.bonginkosi.salaryservice.dto.SalaryDto;
import com.bonginkosi.salaryservice.dto.EmployeeDto;
import com.bonginkosi.salaryservice.entity.Salary;
import com.bonginkosi.salaryservice.repository.SalaryRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class SalaryService {

    @Autowired
    private final SalaryRepository salaryRepository;
    private final UserClient userClient;

    public SalaryService(SalaryRepository salaryRepository,UserClient userClient) {
        this.salaryRepository = salaryRepository;
        this.userClient = userClient;
    }


    //Method to create salary record
    // Create Salary Record
    public SalaryDto createSalary(SalaryDto salaryDto) {

        // Verify that the employee exists
        EmployeeDto employee;

        try {
            employee = userClient.getUserById(salaryDto.getUserId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException(
                    "User with ID " + salaryDto.getUserId() + " was not found."
            );
        }

        // Create Entity
        Salary salary = new Salary();

        salary.setBasicSalary(salaryDto.getBasicSalary());
        salary.setBonus(salaryDto.getBonus());
        salary.setDeductions(salaryDto.getDeductions());
        salary.setUserId(employee.getId());

        // Save
        Salary savedSalary = salaryRepository.save(salary);

        // Build Response
        SalaryDto response = new SalaryDto();

        response.setId(savedSalary.getId());
        response.setBasicSalary(savedSalary.getBasicSalary());
        response.setBonus(savedSalary.getBonus());
        response.setDeductions(savedSalary.getDeductions());
        response.setUserId(savedSalary.getUserId());

        return response;
    }


}
