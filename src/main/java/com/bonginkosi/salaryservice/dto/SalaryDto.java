
package com.bonginkosi.salaryservice.dto;
import java.math.BigDecimal;

public class SalaryDto {
    private Integer id;
    private BigDecimal basicSalary;
    private BigDecimal bonus;
    private BigDecimal deductions;
    private BigDecimal tax;
    private BigDecimal overtimePay;
    private Integer userId;

    //Default constructor
    public SalaryDto() {}

    //Parameterized constructor
    public SalaryDto(BigDecimal basicSalary, BigDecimal bonus,BigDecimal deductions,BigDecimal tax,BigDecimal overtimePay, Integer userId) {

        this.basicSalary = basicSalary;
        this.bonus = bonus;
        this.deductions = deductions;
        this.tax = tax;
        this.overtimePay = overtimePay;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}