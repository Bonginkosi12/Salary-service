package com.bonginkosi.salaryservice.service;

import com.bonginkosi.salaryservice.dto.SalaryDto;
import com.bonginkosi.salaryservice.entity.Salary;
import com.bonginkosi.salaryservice.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryService {

    private SalaryRepository salaryRepository;
    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    //Method to create salary record
    public SalaryDto createSalary(SalaryDto salaryDto) {
        Salary salary = new Salary();
        salary.setBasicSalary(salaryDto.getBasicSalary());
        salary.setBonus(salaryDto.getBonus());
        salary.setDeductions(salaryDto.getDeductions());
        salary.setTax(salaryDto.getTax());
        salary.setOvertimePay(salaryDto.getOvertimePay());
        salary.setUserId(salaryDto.getUserId());
        salaryRepository.save(salary);

        return salaryDto;
    }




}
