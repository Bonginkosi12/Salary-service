package com.bonginkosi.salaryservice.consumer;

import com.bonginkosi.salaryservice.event.EmployeeCreatedEvent;
import com.bonginkosi.salaryservice.service.SalaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log =
            LoggerFactory.getLogger(EmployeeEventConsumer.class);

    @RabbitListener(queues = "salary.queue")
    public void consumeEmployeeCreated(EmployeeCreatedEvent event) {

        log.info("Received Employee Created Event: {}", event);

        // Creating salary record for the employee
        salaryService.createSalaryForEmployee(event);
    }
}