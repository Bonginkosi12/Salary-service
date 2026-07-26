package com.bonginkosi.salaryservice.service;

import com.bonginkosi.salaryservice.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "employee-service",
        url = "http://localhost:8080"
)
public interface UserClient {

    @GetMapping("/users/{id}")
    EmployeeDto getUserById(@PathVariable Integer id);

}
