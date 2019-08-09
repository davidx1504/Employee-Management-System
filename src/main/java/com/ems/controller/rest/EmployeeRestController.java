package com.ems.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@RestController
@RequestMapping("/employee/REST")
public class EmployeeRestController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee() {
		return service.getAllEmployee();
	}
	
	@GetMapping("/{empId}")
	public Employee getOneEmployee(@PathVariable("empId") String empId) {
		return service.getByEmpId(empId);
	}
	
	@PostMapping("/create")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	
	@PutMapping("/update/{empId}")
	public Employee updateEmployee(@PathVariable("empId") String empId, @RequestBody Employee emp) {
		emp.setEmpId(empId);
		return service.udpateEmployee(emp);
	}
	
	@DeleteMapping("/delete/{empId}")
	public boolean deleteEmployee(@PathVariable("empId") String empId) {
		return service.deleteEmployeeByEmpId(empId);
	}
}
