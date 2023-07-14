package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByEmployeeNumber(String employeeNumber);

    List<Employee> findByEmployeeNumberLike(String employeeNumber);


}
