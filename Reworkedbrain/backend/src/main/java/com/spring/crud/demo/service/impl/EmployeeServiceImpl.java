package com.spring.crud.demo.service.impl;

import com.spring.crud.demo.model.Employee;
import com.spring.crud.demo.repository.EmployeeRepository;
import com.spring.crud.demo.service.EmployeeService;
import com.spring.crud.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> getShiftByEmployeeNumber(String employeeNumber) {
        return (List<Employee>) repository.findByEmployeeNumber(employeeNumber);
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(int employeeNumber, Employee employee) {
        Employee existingEmployee = repository.findById(employeeNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this employeeNumber: " + employeeNumber));

        existingEmployee.setEmployeeNumber(employee.getEmployeeNumber());
        existingEmployee.setDate(employee.getDate());
        existingEmployee.setStartTime(employee.getStartTime());
        existingEmployee.setEndTime(employee.getEndTime());
        existingEmployee.setLocation(employee.getLocation());
		existingEmployee.setShiftID(employee.getShiftID());

        return repository.save(existingEmployee);
    }

    @Override
    public Employee patchEmployee(int employeeNumber, Employee employeeDetails) {
        Employee existingEmployee = repository.findById(employeeNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this employeeNumber: " + employeeNumber));

        if (employeeDetails.getEmployeeNumber() != 0) {
            existingEmployee.setEmployeeNumber(employeeDetails.getEmployeeNumber());
        }
        if (employeeDetails.getDate() != 0) {
            existingEmployee.setDate(employeeDetails.getDate());
        }
        if (employeeDetails.getStartTime() != null) {
            existingEmployee.setStartTime(employeeDetails.getStartTime());
        }
		if (employeeDetails.getShiftID() != 0) { // Change from null to 0
			existingEmployee.setShiftID(employeeDetails.getShiftID());
        }
        if (employeeDetails.getEndTime() != null) {
            existingEmployee.setEndTime(employeeDetails.getEndTime());
        }
        if (employeeDetails.getLocation() != null) {
            existingEmployee.setLocation(employeeDetails.getLocation());
        }

        return repository.save(existingEmployee);
    }


	@Override
	public Employee getShiftByShiftID(String shiftID) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShiftByShiftID'");
	}

    @Override
    public void deleteEmployee(int employeeNumber) {
        repository.deleteById(employeeNumber);
    }

	@Override
	public Employee getShiftByEndtime(String endTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShiftByEndtime'");
	}

	@Override
	public Employee getShiftByLocation(String location) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShiftByLocation'");
	}

	@Override
	public Employee getShiftByDate(String date) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShiftByDate'");
	}

	@Override
	public List<Employee> getShiftByStartTime(String startTime) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getShiftByStartTime'");
	}
}