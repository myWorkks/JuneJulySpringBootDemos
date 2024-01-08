package com.marolix.session.JuneJulySpringBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.repository.EmployeeRepository;

@Service(value = "empServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(Employee emp) {
		employeeRepository.save(emp);
		return "emp added successfully";
	}

	@Override
	public List<Employee> viewAllEmployees() {
		Iterable<Employee> itrEmp = employeeRepository.findAll();

		List<Employee> list = new ArrayList<Employee>();

		itrEmp.forEach((Employee e) -> list.add(e));
		return list;
	}

	@Override
	public Employee viewEmployee(Long empId) {
		Optional<Employee> optEmployee = employeeRepository.findById(empId);

		Employee emp = optEmployee.orElseThrow(() -> new RuntimeException("no employee found with id " + empId));
		return emp;
	}

	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
		System.out.println("employee deleted successfully with " + empId);
	}

	@Override
	public void deleteAllEmployeeData() {
		employeeRepository.deleteAll();
		System.out.println("all employees deleted");
	}

}
