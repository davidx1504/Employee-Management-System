package com.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.model.Employee;
import com.ems.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	public boolean validateEmployee(Employee emp){
		boolean retFlag = true;
		String empName = emp.getEmpName();
		LocalDate dob = emp.getDob();
		if(empName.length()<4) {
			retFlag = false;
		}
		if(empName.length()>15) {
			retFlag = false;
		}
		if(dob.isAfter(LocalDate.of(1995, 12, 31)) || dob.isBefore(LocalDate.of(1900, 1, 1))) {
			retFlag = false;
		}
		float salary = emp.getSalary();
		if(salary<20000f || salary>80000f) {
			retFlag = false;
		}
		return retFlag;
	}
	
	public String generateId(String empName) {
		String retStr = "";
		Random rand = new Random();
		retStr= empName.substring(0,2) + String.format("%04d", rand.nextInt(10000));
		return retStr;
	}
	
	public Employee addEmployee(Employee emp) {
		Employee ret = null;
		emp.setEmpId(generateId(emp.getEmpName()));
		if(validateEmployee(emp)) {
			ret =  repo.save(emp);
		}
		return ret;
	}
	
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}
	
	public Employee getEmployee(int empId) {
		return repo.getOne(empId);
	}
	
	public Employee getByEmpId(String empId) {
		return repo.findByEmpId(empId);
	}
	
	public void deleteEmployee(int empId) {
		repo.deleteById(empId);
	}
	
	public boolean deleteEmployeeByEmpId(String empId) {
		Employee emp = getByEmpId(empId);
		if(emp==null) {
			return false;	
		}
		else {
			deleteEmployee(emp.getId());	
			return true;
		}
	}

	public Employee udpateEmployee(Employee emp) {
		if(emp.getEmpId()==null) {
			return null;
		}
		Employee ret = null;
		Employee old = repo.findByEmpId(emp.getEmpId());
		if(old==null)
			return null;
		ret = new Employee();
		ret.setId(old.getId());
		ret.setEmpId(emp.getEmpId());
		ret.setDob(emp.getDob()==null?old.getDob():emp.getDob());
		ret.setEmpName(emp.getEmpName()==null?old.getEmpName():emp.getEmpName());
		ret.setSalary(emp.getSalary()==0f?old.getSalary():emp.getSalary());
		
		if(validateEmployee(ret)) {
			ret =  repo.save(ret);
		}else {
			ret = null;
		}
		return ret;
	}
}
