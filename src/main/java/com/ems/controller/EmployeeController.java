package com.ems.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ems.model.Employee;
import com.ems.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/all")
	public String getAllEmployee(Model m) {
		List<Employee> list = service.getAllEmployee();
		m.addAttribute("empData",list);
		m.addAttribute("type", "list");
		System.out.println("request handled");
		return "/view/show.jsp";
	}
	
	@PostMapping("/find")
	public String getAllEmployee(@RequestParam("empId") String empId, Model m) {
		Employee emp = service.getByEmpId(empId);
		m.addAttribute("empData",emp);
		if(emp==null) {
			m.addAttribute("message", "Employee not found");	
		}
		m.addAttribute("type", "object");
		return "/view/show.jsp";
	}
	
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee emp, Model m) {
		System.out.println(emp);
		String message;
		Employee e = service.addEmployee(emp);
		if( e != null ) {
			message="Employee added successfully";
		}
		else {
			message = "Employee addition failed";
		}
		m.addAttribute("empData", e);
		m.addAttribute("message", message);
		m.addAttribute("type","object");
		return "/view/show.jsp";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("empId") String empId, Model m) {
		boolean state = service.deleteEmployeeByEmpId(empId);
		if(!state) {
			m.addAttribute("message", "No employee found with Id = "+empId);	
		}
		else {
			m.addAttribute("message", "Deleted Employee with Id = "+empId);
		}
		return "/view/show.jsp";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee inemp, Model m) {
		Employee emp = service.udpateEmployee(inemp);
		if(emp == null) {
			m.addAttribute("message", "updation failed");	
		}
		else {
			m.addAttribute("message", "updation");
		}
		m.addAttribute("empData",inemp);
		m.addAttribute("type", "object");
		return "/view/show.jsp";
	}
	
	@RequestMapping("/search")
	public String getUpdateData(@RequestParam(name="empId") String empId, Model m) {
		Employee emp = service.getByEmpId(empId);
		if(emp==null) {
			m.addAttribute("message", "No employee found with Id "+empId);	
		}
		else {
			m.addAttribute("message", "Editing Employee with Id "+empId);
		}
		HashMap<String, String> hiddenParam = new HashMap<>();
		hiddenParam.put("empId", empId);
		
		m.addAttribute("title","Update Employee");
		m.addAttribute("hiddenParam",hiddenParam);
		m.addAttribute("details", "all");
		m.addAttribute("action", "update");
		m.addAttribute("empData",emp);
		return "/getEmpDetails.jsp";
	}
}
