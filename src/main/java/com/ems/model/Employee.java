package com.ems.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Employee implements Model{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String empId;
	private String empName;
	private float salary;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dob;
	
	public Employee() {

	}
	
	

	public Employee(int id, String empId, String empName, float salary, LocalDate dob) {
		super();
		this.id = id;
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.dob = dob;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", dob="
				+ dob + "]";
	}



	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmpId() {
		return empId;
	}



	public void setEmpId(String empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	 public List<String> toList(){
		 List<String> list = new ArrayList<String>();
		 list.add(String.valueOf(this.empId));
		 list.add(this.empName);
		 list.add(this.dob.toString());
		 list.add(String.valueOf(this.salary));
		 return list;
	 }
}
