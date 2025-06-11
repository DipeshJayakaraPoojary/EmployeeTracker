package com.example.attendance;

import com.example.attendance.model.Department;
import com.example.attendance.model.Employee;
import com.example.attendance.repository.DepartmentRepository;
import com.example.attendance.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AttendanceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttendanceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepo, DepartmentRepository departmentRepo) {
        return args -> {
            Department dept = new Department();
            dept.setName("Engineering");
            dept = departmentRepo.save(dept);

            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setEmail("john@example.com");
            emp.setDepartmentId(dept.getId());
            employeeRepo.save(emp);
        };
    }
}
