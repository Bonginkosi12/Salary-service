
package com.bonginkosi.salaryservice.dto;
import java.math.BigDecimal;

public class SalaryDto {
    private Integer id;
    private BigDecimal basicSalary;
    private BigDecimal bonus;
    private BigDecimal deductions;
    private BigDecimal tax;
    private BigDecimal overtimePay;
    private Integer employeeId;

    //Default constructor
    public SalaryDto() {}

    //Parameterized constructor
    public SalaryDto(Integer id,BigDecimal basicSalary, BigDecimal bonus,BigDecimal deductions,BigDecimal tax,BigDecimal overtimePay, Integer employeeId) {
        this.id = id;
        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deductions = deductions;
        this.tax = tax;
        this.overtimePay = overtimePay;
        this.employeeId = employeeId;
    }

    public SalaryDto(BigDecimal basicSalary, BigDecimal bonus, BigDecimal deductions, BigDecimal tax, BigDecimal overtimePay) {
    }

    //Getters and Setters

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getBonus() {
        return bonus;
    }
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getDeductions() {
        return deductions;
    }
    public void setDeductions(BigDecimal deductions) {
        this.deductions = deductions;
    }

    public BigDecimal getTax() {
        return tax;
    }
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }
    public BigDecimal getOvertimePay() {
        return overtimePay;
    }
    public void setOvertimePay(BigDecimal overtimePay) {
        this.overtimePay = overtimePay;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //Converts EmployeeDto object into a text and writes it into a log
    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", basicSalary='" + basicSalary + '\'' +
                ", bonus='" + bonus + '\'' +
                ", deduction=" + deductions +
                ", tax='" + tax + '\'' +
                ", overtimePay='" + overtimePay + '\'' +
                ", employeeId='" + employeeId + '\'' +
                '}';
    }


}