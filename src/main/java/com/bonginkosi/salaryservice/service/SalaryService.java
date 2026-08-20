package com.bonginkosi.salaryservice.service;

import com.bonginkosi.salaryservice.dto.SalaryDto;
import com.bonginkosi.salaryservice.dto.EmployeeDto;
import com.bonginkosi.salaryservice.entity.Salary;
import com.bonginkosi.salaryservice.event.EmployeeCreatedEvent;
import com.bonginkosi.salaryservice.repository.SalaryRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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
            employee = userClient.getEmployeeById(salaryDto.getEmployeeId());
        } catch (FeignException.NotFound ex) {
            throw new RuntimeException(
                    "User with ID " + salaryDto.getEmployeeId() + " was not found."
            );
        }

        // Create Entity object
        Salary salary = new Salary();

        salary.setBasicSalary(salaryDto.getBasicSalary());
        salary.setBonus(salaryDto.getBonus());
        salary.setDeductions(salaryDto.getDeductions());
        salary.setTax(salaryDto.getTax());
        salary.setOvertimePay(salaryDto.getOvertimePay());
        salary.setEmployeeId(employee.getId());

        salaryRepository.save(salary);

        return salaryDto;
    }

    //Method to create Salary record when an employee is created
    public void createSalaryForEmployee(EmployeeCreatedEvent event) {

        Salary salary = new Salary();

        salary.setEmployeeId(event.getId());

        salary.setBasicSalary(BigDecimal.ZERO);
        salary.setBonus(BigDecimal.ZERO);
        salary.setDeductions(BigDecimal.ZERO);
        salary.setTax(BigDecimal.ZERO);
        salary.setOvertimePay(BigDecimal.ZERO);

        salaryRepository.save(salary);
    }

    // method to update a salary record
    public SalaryDto updateSalary(Integer id, SalaryDto salaryDto) {
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salary record not found"));

        if (salaryDto.getBasicSalary() != null) {
            salary.setBasicSalary(salaryDto.getBasicSalary());
        }

        if (salaryDto.getBonus() != null) {
            salary.setBonus(salaryDto.getBonus());
        }

        if (salaryDto.getDeductions() != null) {
            salary.setDeductions(salaryDto.getDeductions());
        }

        if (salaryDto.getTax() != null) {
            salary.setTax(salaryDto.getTax());
        }

        if (salaryDto.getOvertimePay() != null) {
            salary.setOvertimePay(salaryDto.getOvertimePay());
        }
        salaryRepository.save(salary);

        return new SalaryDto(
                salary.getBasicSalary(),
                salary.getBonus(),
                salary.getDeductions(),
                salary.getTax(),
                salary.getOvertimePay()
        );

    }


}










