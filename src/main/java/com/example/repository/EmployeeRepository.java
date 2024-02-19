package com.example.repository;

import com.example.model.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    /*Optional solo si el dato de parametro es unico*/
    Optional<Employee> findByFullName(String fullname);
    Optional<Employee> findByFullNameOrBirthDate(String fullName, LocalDate birthDate);
    List<Employee> findAllByBirthDateAfter(LocalDate birthDate);
    List<Employee> findAllByBirthDateBetween(LocalDate min,LocalDate max);
    List<Employee> findAllByMarriedTrue();
    List<Employee> findAllByMarriedFalse();


}

