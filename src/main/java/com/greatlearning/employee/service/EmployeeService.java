package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.model.Employee;

//SERVICE LAYER INTERFACE
public interface EmployeeService {
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
