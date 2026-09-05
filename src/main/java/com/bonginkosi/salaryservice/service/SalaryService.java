package com.bonginkosi.salaryservice.service;

import com.bonginkosi.salaryservice.consumer.EmployeeEventConsumer;
import com.bonginkosi.salaryservice.dto.SalaryDto;
import com.bonginkosi.salaryservice.dto.EmployeeDto;
import com.bonginkosi.salaryservice.entity.Salary;
import com.bonginkosi.salaryservice.event.EmployeeCreatedEvent;
import com.bonginkosi.salaryservice.repository.SalaryRepository;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SalaryService {

    @Autowired
    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    private static final Logger log =
            LoggerFactory.getLogger(SalaryService.class);


    //Method to create Salary record when an employee is created
    public void createSalaryForEmployee(EmployeeCreatedEvent event) {

        log.info("Creating salary record");
        try {
            Salary salary = new Salary();

            salary.setEmployeeId(event.getId());

            salary.setBasicSalary(BigDecimal.ZERO);
            salary.setBonus(BigDecimal.ZERO);
            salary.setDeductions(BigDecimal.ZERO);
            salary.setTax(BigDecimal.ZERO);
            salary.setOvertimePay(BigDecimal.ZERO);

            salaryRepository.save(salary);
            log.info("Salary record created for employee with ID {} ", event.getId());
        }

        //If error occurs in try block
        catch (Exception ex) {
            log.error("Failed to create salary record for the employee", ex);
            throw ex;
        }
    }

    // method to update a salary record
    public SalaryDto updateSalary(Integer id, SalaryDto salaryDto) {

        try {
            log.info("Updating salary record");
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
            log.info("Salary record updated successfully: {}", salary);

            return new SalaryDto(
                    salary.getBasicSalary(),
                    salary.getBonus(),
                    salary.getDeductions(),
                    salary.getTax(),
                    salary.getOvertimePay()
            );
        }
        catch (Exception ex) {
            log.error("Failed to update salary record for the employee", ex);
            throw ex;
        }

    }


}










