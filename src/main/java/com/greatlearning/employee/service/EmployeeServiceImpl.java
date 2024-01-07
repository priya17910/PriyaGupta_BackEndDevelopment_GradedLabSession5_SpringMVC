package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	// SERVICE CODE TO FIND ALL THE LIST OF EMPLOYEES
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	// SERVICE CODE TO FIND THE EMPLOYEE BY ID
	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee employee = null;
		if (result.isPresent())
		{
			employee = result.get();
		}
		else
		{
			throw new RuntimeException("Employee is not present with the given id: " + theId);
		}
		return employee;
	}

	// SERVICE CODE TO SAVE THE EMPLOYEE
	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	// SERVICE CODE TO DELETE THE EMPLOYEE BY ID
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
