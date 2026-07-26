//DTO representing the User(represents the JSON returned by User-Service)
package com.bonginkosi.salaryservice.dto;

public class EmployeeDto {

    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String mobileNumbers;
    private String role;
    private String employmentType;
    private String department;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(String mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getEmploymentType() {
        return employmentType;
    }
    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
