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

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", designation=" + designation
				+ ", salary=" + salary + ", phoneNumber=" + phoneNumber + ", email=" + email + ", doj=" + doj + "]";
	}

}
