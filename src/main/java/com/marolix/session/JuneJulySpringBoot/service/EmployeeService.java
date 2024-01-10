package com.marolix.session.JuneJulySpringBoot.service;

import java.util.List;

import com.marolix.session.JuneJulySpringBoot.dto.EmployeeDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;

public interface EmployeeService {
	public String addEmployee(EmployeeDTO emp) throws Throwable;

	public List<Employee> viewAllEmployees();

	public Employee viewEmployee(Long empId);

	public void deleteEmployee(Long empId);

	public void deleteAllEmployeeData();

	public List<Employee> searchByDesignation(String designation);

	public List<EmployeeDTO> filterEmployeesBySalarayRange(Double minSalaray, Double maxSalaray);
}
