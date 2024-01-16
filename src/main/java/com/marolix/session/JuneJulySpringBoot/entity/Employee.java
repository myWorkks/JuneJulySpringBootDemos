package com.marolix.session.JuneJulySpringBoot.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "emp_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long employeeId;// employee_id
	private String empName;// emp_name
	@Column(name = "emp_designation")
	private String designation;
	@Column(name = "emp_salary")
	private Double salary;
	@Column(unique = true)
	private String phoneNumber;
	@Column(nullable = false)
	private String email;
	@Column
	private LocalDate doj;

	public Employee(Long employeeId, String empName, String designation, Double salary, String phoneNumber,
			String email, LocalDate doj) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.doj = doj;
	}

	public Employee() {
		super();

	}

	public Employee(String empName, Double salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}

	public Employee(String empName, String designation, Double salary, String phoneNumber, String email,
			LocalDate doj) {
		super();
		this.empName = empName;
		this.designation = designation;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", designation=" + designation
				+ ", salary=" + salary + ", phoneNumber=" + phoneNumber + ", email=" + email + ", doj=" + doj + "]";
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

}
