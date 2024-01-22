package com.marolix.session.JuneJulySpringBoot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.cglib.core.Local;

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

	public List<EmployeeDTO> filterByDOJ(LocalDate date);

	public List<Employee> fetchSpecifiedColumns();

	public String updateEmployees(Double currentSalaray,Double increment);
	
	public List<EmployeeDTO> sortBySlaray();
	
	public List<EmployeeDTO> sortBySpecific(String columnName);
	
	
	public List<EmployeeDTO> fetchByPaging(Integer pgNo,Integer pgSize);
	
}
