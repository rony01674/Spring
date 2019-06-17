package com.springioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public Employee obj() {
        Employee employee = new Employee();
        employee.setId(001);
        employee.setName("Asaduzzaman Rony");
        employee.setCity("Narayanganj");

        return employee;
    }
}
