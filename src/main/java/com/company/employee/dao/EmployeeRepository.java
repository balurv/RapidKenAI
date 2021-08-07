package com.company.employee.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.company.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String>{
	

}
