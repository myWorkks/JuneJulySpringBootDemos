package com.marolix.session.JuneJulySpringBoot.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.marolix.session.JuneJulySpringBoot.dto.EmpAddressDTO;
import com.marolix.session.JuneJulySpringBoot.dto.EmployeeDTO;
import com.marolix.session.JuneJulySpringBoot.dto.SalaryAccountDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeAddressService;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeService;
import com.marolix.session.JuneJulySpringBoot.service.SalaryAccountService;

@Controller(value = "empController")
public class EmployeeController {
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeService empService;
	@Autowired
	private SalaryAccountService salaryAccountService;
	@Autowired
	private EmployeeAddressService employeeAddressService;

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
		EmployeeDTO empDTO = new EmployeeDTO(empName, designation, salaray, phNumber, email, d);
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
		Scanner sc = new Scanner(System.in);
		double minSalary = sc.nextDouble();
		System.out.println(" enter max salaray");
		double maxSalary = sc.nextDouble();
		empService.filterEmployeesBySalarayRange(minSalary, maxSalary).forEach(System.out::println);
	}

	public void filterByDoj() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter date in format dd/MM/YYYY");
		String date = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d = LocalDate.parse(date, dtf);
		empService.filterByDOJ(d).forEach(e -> System.out.println(e));

	}

	public void fectchSpecifiedColumns() {
		empService.fetchSpecifiedColumns().forEach(e -> System.out.println(e));
	}

	public void updateEMployeeSalaray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter salaray");
		System.out.println("enter increment");
		String msg = empService.updateEmployees(sc.nextDouble(), sc.nextDouble());
		logger.info(msg);
	}

	public void addBankDetails() throws EmployeeManagementException {
		System.out.println("enter empid");
		Scanner sc = new Scanner(System.in);
		Long empId = sc.nextLong();
		System.out.println("enter bank details");
		System.out.println("enter account number");
		String accountNo = sc.next();
		System.out.println("enter ifsc code");
		String ifsc = sc.next();
		System.out.println("enter branch name");
		String branch = sc.next();
		System.out.println("enter account holder name");
		String name = sc.next();
		// String accountNumber, String accountHolderName, String ifsc, String branch,
		// Long empId
		SalaryAccountDTO sadto = new SalaryAccountDTO(accountNo, name, ifsc, branch, empId);
		String msg = salaryAccountService.addBankDetails(sadto);
		logger.info(msg);

	}

	public void addAddress() throws EmployeeManagementException {
		System.out.println("enter address details");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter hno");
		String hno = sc.next();
		System.out.println("enter street");
		String street = sc.next();
		System.out.println("enter city");
		String city = sc.next();
		System.out.println("enter state");
		String state = sc.next();
		System.out.println("enter pincode");
		String pincode = sc.next();

		EmpAddressDTO empAddressDTO = new EmpAddressDTO(hno, street, city, state, pincode);

		System.out.println("employee id");
		Long empId = sc.nextLong();
		// Long->Integer
		// int->long //implicit
		// long->int //explict
		employeeAddressService.addEmpAddress(empId.intValue(), empAddressDTO);
	}

	public void sortBySalary() {
		empService.sortBySlaray().forEach(e -> System.out.println(e));
	}

	public void sortBySpecificColumn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the sorting column name");
		String colname = sc.next();
		empService.sortBySpecific(colname).forEach(e -> System.out.println(e));
	}

	public void fetchByPaging() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter page no");
		int pgNo = sc.nextInt();
		System.out.println("enter no of entities per page");
		int noOfEntities = sc.nextInt();

		empService.fetchByPaging(pgNo, noOfEntities).forEach(e -> System.out.println(e));
	}
}
