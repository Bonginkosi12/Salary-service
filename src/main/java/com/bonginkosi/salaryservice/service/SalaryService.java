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
    public SalaryDto createSalary(SalaryDto salaryDto) {

        // Verify that the employee exists
        EmployeeDto employee;

        try {
            employee = userClient.getEmployeeById(salaryDto.getUserId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException(
                    "User with ID " + salaryDto.getUserId() + " was not found."
            );
        }

        // Create Entity object
        Salary salary = new Salary();

        salary.setBasicSalary(salaryDto.getBasicSalary());
        salary.setBonus(salaryDto.getBonus());
        salary.setDeductions(salaryDto.getDeductions());
        salary.setTax(salaryDto.getTax());
        salary.setOvertimePay(salaryDto.getOvertimePay());
        salary.setUserId(employee.getId());

        salaryRepository.save(salary);

        return salaryDto;
    }

}
