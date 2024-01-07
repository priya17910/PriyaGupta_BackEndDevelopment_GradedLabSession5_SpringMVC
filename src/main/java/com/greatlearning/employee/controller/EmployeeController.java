package com.greatlearning.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	// CONTROLLER CODE TO GET THE LIST OF EMPLOYEES
	@GetMapping("/list")
	public String findAll(Model model)
	{
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employee/list-of-employees";
	}
	
	// CONTROLLER CODE TO SHOW THE FORM FOR CREATING NEW EMPLOYEE
		@GetMapping("/showEmployeeFormForAdd")
		public String showEmployeeFormForAdd(Model model)
		{
			Employee theEmployee = new Employee();
			model.addAttribute("employee", theEmployee);
			model.addAttribute("add", true);
			return "employee/employee-form";
		}
		
		// CONTROLLER CODE TO SAVE THE CREATED OR UPDATED EMPLOYEE
		@PostMapping("/saveEmployee")
		public String saveBook(Model model, @ModelAttribute("employee") Employee employee)
		{
			employeeService.save(employee);
			return "redirect:/employees/list?ed";
		}
		
		// CONTROLLER CODE TO DELETE EMPLOYEE
		@GetMapping("/delete/{id}")
		public String delete(Model model, @PathVariable int id)
		{
			employeeService.deleteById(id);
			return "redirect:/employees/list?del";
		}
		
		// CONTROLLER CODE TO SHOW THE FORM FOR UPDATING THE EMPLOYEE
		@GetMapping("/showEmployeeFormForEdit/{id}")
		public String showEmployeeFormForEdit(Model model, @PathVariable int id)
		{
			Employee theEmployee = employeeService.findById(id);
			model.addAttribute("employee", theEmployee);
			model.addAttribute("edit", true);
			return "employee/employee-form";
		}
}
