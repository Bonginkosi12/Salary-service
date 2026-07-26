
package com.bonginkosi.salaryservice.entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "employees_salary")

public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id")
    private Integer id;

    @Column(name = "basic_salary")
    private BigDecimal basicSalary;

    @Column(name = "bonus")
    private BigDecimal bonus;

    @Column(name = "deductions")
    private BigDecimal deductions;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "overtimePay")
    private BigDecimal overtimePay;

    @Column(name = "user_id")
    private Integer userId;


    // Getters and Setters methods to access and modify the attributes
    //For id
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    //For basicSalary
    public BigDecimal getBasicSalary() {
        return basicSalary;
    }
    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    //For bonus
    public BigDecimal getBonus() {
        return bonus;
    }
    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    //For deductions
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

    //For userId
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
