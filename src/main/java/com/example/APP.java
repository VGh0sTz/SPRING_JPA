package com.example;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

/*
 DB ---> JDBC ---> Hibernate ---> Spring Data JPA
*/
@SpringBootApplication
public class APP {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(APP.class, args);
       var employeeRepo = context.getBean(EmployeeRepository.class);

       List<Employee> employees= List.of(
               new Employee(null,"employee1",true, LocalDate.now()),
               new Employee(null,"employee2",false, LocalDate.now()),
               new Employee(null,"employee3",true, LocalDate.now()),
               new Employee(null,"employee4",false, LocalDate.now()),
               new Employee(null,"employee5",true, LocalDate.now())
       );
       employeeRepo.saveAll(employees);

       employeeRepo.findAllByMarriedTrue().forEach(System.out::println);
    }
}
