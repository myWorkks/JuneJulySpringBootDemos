package com.marolix.session.JuneJulySpringBoot.service;

import java.util.List;

import com.marolix.session.JuneJulySpringBoot.entity.Employee;

public interface EmployeeService {
	public String addEmployee(Employee emp);

	public List<Employee> viewAllEmployees();

	public Employee viewEmployee(Long empId);

	public void deleteEmployee(Long empId);
	public void deleteAllEmployeeData();
	
}
