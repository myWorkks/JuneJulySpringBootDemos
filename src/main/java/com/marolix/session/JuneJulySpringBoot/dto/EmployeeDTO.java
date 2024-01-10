package com.marolix.session.JuneJulySpringBoot.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeDTO {

	private Long employeeId;// employee_id
	private String empName;// emp_name

	private String designation;

	private Double salary;

	private String phoneNumber;

	private String email;
	private LocalDate doj;

	public EmployeeDTO(String empName, String designation, Double salary, String phoneNumber, String email,
			LocalDate doj) {
		super();
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.doj = doj;
	}

	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", empName=" + empName + ", designation=" + designation
				+ ", salary=" + salary + ", phoneNumber=" + phoneNumber + ", email=" + email + ", doj=" + doj + "]";
	}

}
