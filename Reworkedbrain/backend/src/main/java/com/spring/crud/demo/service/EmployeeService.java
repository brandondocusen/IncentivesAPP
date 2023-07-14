package com.spring.crud.demo.service;

import com.spring.crud.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> getAll();

	Employee getShiftByShiftID(String shiftID);

	List<Employee> getShiftByEmployeeNumber(String employeeNumber);

	Employee getShiftByDate(String date);

	List<Employee> getShiftByStartTime(String startTime);

	Employee getShiftByEndtime(String endTime);

	Employee getShiftByLocation(String location);

	Employee saveEmployee(Employee employee);

	Employee updateEmployee(int employeeNumber, Employee employee);

	Employee patchEmployee(int employeeNumber, Employee employeeDetails);

	void deleteEmployee(int employeeNumber);

}
