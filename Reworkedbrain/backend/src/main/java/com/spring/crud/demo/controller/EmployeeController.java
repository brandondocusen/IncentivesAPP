package com.spring.crud.demo.controller;

import com.spring.crud.demo.model.Employee;
import com.spring.crud.demo.model.EmployeeList;
import com.spring.crud.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{shiftID}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int shiftID, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(shiftID, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    @PatchMapping("/{shiftID}")
    public ResponseEntity<Employee> patchEmployee(@PathVariable int shiftID, @RequestBody Employee employeeDetails) {
        Employee patchedEmployee = employeeService.patchEmployee(shiftID, employeeDetails);
        return ResponseEntity.ok(patchedEmployee);
    }

    @DeleteMapping("/{shiftID}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int shiftID) {
        employeeService.deleteEmployee(shiftID);
        return ResponseEntity.noContent().build();
    }

}