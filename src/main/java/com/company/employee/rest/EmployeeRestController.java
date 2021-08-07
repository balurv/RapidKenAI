package com.company.employee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.employee.entity.Employee;
import com.company.employee.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/api/employee/list")
	public List<Employee> employeeList(Model model, @RequestParam("pageSize") Integer pageSize, @RequestParam("page") Integer page) {
		List<Employee> employees = employeeService.getAllEmployeesByPage(page, pageSize);
		model.addAttribute("employeeList", employees);
		return employees;

	}
	
	@PostMapping("/api/employee/list")
	public List<Employee> employeeSearch(Model model, 
										@RequestParam("department") String department, 
										@RequestParam("position") String position,
										@RequestParam("pageSize") Integer pageSize, 
										@RequestParam("page") Integer page){
										
		List<Employee> employees = employeeService.getAllEmployeesByDepartmentAndPositionAndPage(department, position, page, pageSize);
		model.addAttribute("employeeList", employees);
		return employees;

	}
}
