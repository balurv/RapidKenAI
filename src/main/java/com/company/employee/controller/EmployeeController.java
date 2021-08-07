package com.company.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.employee.entity.Employee;
import com.company.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value={"/","/home", "/index"})
	public String home(Model model) {
		return "index";

	}

	@GetMapping("/addEmployee")
	public String addEmployeeGet(Model model) {
		return "addEmployee";

	}
	
	@PostMapping("/addEmployee")
	public String addEmployeePost(Model model,
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name = "lastName") String lastName,
			@RequestParam(name = "salary") Integer salary,
			@RequestParam(name = "department") String department,
			@RequestParam(name = "position") String position,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "phoneNumber") String phoneNumber) {
			
		System.out.println("firstName "+firstName);
		System.out.println("lastName "+lastName);

		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		employee.setDepartment(department);
		employee.setPosition(position);
		employee.setEmail(email);
		employee.setPhoneNumber(phoneNumber);
		
		System.out.println("Employee "+employee.toString());
		employeeService.save(employee);
		
		return "redirect:/employee/list";

	}
	
	@GetMapping("/employee/list")
	public String employeeList(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employeeList", employees);
		return "employees";

	}

}
