package com.bonginkosi.salaryservice.consumer;

import com.bonginkosi.salaryservice.event.EmployeeCreatedEvent;
import com.bonginkosi.salaryservice.service.SalaryService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeEventConsumer {

    @Autowired
    private final SalaryService salaryService;
    public EmployeeEventConsumer(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @RabbitListener(queues = "salary.queue")
    public void consumeEmployeeCreated(EmployeeCreatedEvent event) {

        System.out.println(
                "Employee created: " + event.getId()
        );

        System.out.println(
                "Employee name: " + event.getName()
        );

        System.out.println(
                "Employee age: " + event.getAge()
        );

        System.out.println(
                "Employee email: " + event.getEmail()
        );
        System.out.println(
                "Employee mobileNumbers: " + event.getMobileNumbers()
        );

        System.out.println(
                "Employee role: " + event.getRole()
        );

        System.out.println(
                "Employee employmentType: " + event.getEmploymentType()
        );

        System.out.println(
                "Employee department: " + event.getDepartment()
        );


        // Create salary record here
        salaryService.createSalaryForEmployee(event);
    }
}