package com.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.model.Employee;

@Controller
public class Router {

	@RequestMapping("/")
	public String index() {
		return "/index.jsp";
	}
	
	@GetMapping("/employee")
	public String employeeIndex(){
		return "/employeeIndex.jsp";
	}
	
	@GetMapping("/employee/newEmployee")
	public String getEmployeeDetails(Model m) {
		m.addAttribute("title","New Employee");
		m.addAttribute("details", "all");
		m.addAttribute("action", "add");
		return "/getEmpDetails.jsp";
	}
	
	@GetMapping("/employee/findEmployee")
	public String findEmployee(Model m) {
		m.addAttribute("title","Find Employee");
		m.addAttribute("details", "id");
		m.addAttribute("action", "find");
		return "/getEmpDetails.jsp";
	}
	
	
	
	@GetMapping("/employee/deleteEmployee")
	public String deleteEmployee(Model m) {
		m.addAttribute("title","Delete Employee");
		m.addAttribute("details", "id");
		m.addAttribute("action", "delete");
		return "/getEmpDetails.jsp";
	}
	
	@GetMapping("/employee/updateEmployee")
	public String upaateEmployee(Model m) {
		m.addAttribute("title","Update Employee");
		m.addAttribute("details", "id");
		m.addAttribute("action", "search");
		return "/getEmpDetails.jsp";
	}
	
}
