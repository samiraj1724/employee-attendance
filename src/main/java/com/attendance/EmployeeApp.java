package com.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeeApp {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Attendance System!";
    }

    @GetMapping("/mark")
    public String markAttendance() {
        return "Attendance marked successfully!";
    }
}