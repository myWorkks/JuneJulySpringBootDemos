package com.marolix.session.JuneJulySpringBoot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marolix.session.JuneJulySpringBoot.dto.EmployeeDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeService;

@Controller(value = "empController")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	public void addEmployee() throws Throwable {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
//		System.out.println("enter empId");
//		long a = sc.nextInt();// int->Integer

		// auto promotion conncept
		// auot boxing and auto unoxing
		System.out.println("enter emp name");
		String empName = sc.next();
		System.out.println("enter phone number");
		String phNumber = sc.next();
		System.out.println("enter the email");
		String email = sc.next();
//		Long employeeId, String empName, String designation, Double salary, String phoneNumber,
//		String email, LocalDate doj

		System.out.println("enter designation");
		String designation = sc.next();
		System.out.println("enter salary");
		Double salaray = sc.nextDouble();

		System.out.println("enter date in format dd/MM/YYYY");
		String date = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d = LocalDate.parse(date, dtf);
		EmployeeDTO empDTO = new EmployeeDTO( empName, designation, salaray, phNumber, email, d);
		String scMsg = empService.addEmployee(empDTO);
		System.out.println(scMsg);

	}

	public void viewAllEmployees() {
		System.out.println("fetching employees");
		List<Employee> list = empService.viewAllEmployees();
		list.forEach(System.out::println);
	}

	public void viewEmployee() {
		System.out.println("fetching employee details");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter empId");
		long a = sc.nextInt();// int->Integer

		Employee list = empService.viewEmployee(a);
		System.out.println(list);
	}

	public void deleEMployeeWithEMpID() {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter employee details");
		System.out.println("enter empId");
		long a = sc.nextInt();// int->Integer
		empService.deleteEmployee(a);
	}

	public void deleteAllEMployees() {

		empService.deleteAllEmployeeData();
		;
	}

	public void searchByDesignation() {
		System.out.println("enter designation");
		Scanner sc = new Scanner(System.in);
		String designation = sc.next();
		empService.searchByDesignation(designation).stream().forEach(System.out::println);
	}
	
	public void filterEmployessBySalrayRange() {
		System.out.println("enter min salaray ");
		Scanner sc= new Scanner(System.in);
		double minSalary=sc.nextDouble();
		System.out.println(" enter max salaray");
		double maxSalary=sc.nextDouble();
		empService.filterEmployeesBySalarayRange(minSalary, maxSalary).forEach(System.out::println);
	}
}
