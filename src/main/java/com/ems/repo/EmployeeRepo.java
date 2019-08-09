package com.ems.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee where empId=:empId")
	Employee findByEmpId(String empId);
	
}
