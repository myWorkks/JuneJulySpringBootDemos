package com.marolix.session.JuneJulySpringBoot.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeService;

@Controller(value = "empController")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	public void addEmployee() {

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
		Employee emp = new Employee(null, empName, null, null, phNumber, email, null);
		String scMsg = empService.addEmployee(emp);
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
}
