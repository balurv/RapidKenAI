package com.company.employee.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.employee.dao.EmployeeRepository;
import com.company.employee.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@PersistenceContext
	private EntityManager em;

	public void save(Employee employee) {
		employee = repository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = (List<Employee>) repository.findAll();
		return employeeList;
	}

	public List<Employee> getAllEmployeesByPage(Integer page, Integer pageSize) {
		Pageable sortedByName = PageRequest.of(page, pageSize, Sort.by("firstName").and(Sort.by("lastName")));
		Page<Employee> employeeList = repository.findAll(sortedByName);
		return employeeList.toList();
	}

	public List<Employee> getAllEmployeesByDepartmentAndPositionAndPage(String department, String position, Integer page, Integer pageSize){

		
		TypedQuery query = null;
		if(!department.isBlank() && !position.isBlank()) {
			query = em.createQuery("select e from Employee e where e.department = ?1 and e.position =?2", Employee.class);
		}else if(!department.isBlank()) {
			query = em.createQuery("select e from Employee e where e.department = ?1", Employee.class);
		}else if(!position.isBlank()) {
			query = em.createQuery("select e from Employee e where e.position =?2", Employee.class);
		}else {
			query = em.createQuery("select e from Employee e", Employee.class);
		}

		if(!department.isBlank()) {
			query.setParameter(1, department);
		}
		if(!position.isBlank()){
			query.setParameter(2, position);
		}
		query.setFirstResult(page * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();
	}
}
