package com.marolix.session.JuneJulySpringBoot.controller;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marolix.session.JuneJulySpringBoot.dto.EmpAddressDTO;
import com.marolix.session.JuneJulySpringBoot.dto.EmployeeDTO;
import com.marolix.session.JuneJulySpringBoot.dto.SalaryAccountDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeAddressService;
import com.marolix.session.JuneJulySpringBoot.service.EmployeeService;
import com.marolix.session.JuneJulySpringBoot.service.SalaryAccountService;

//@Controller(value = "empController")
//@ResponseBody
@RestController(value = "empController")
public class EmployeeController {
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	private EmployeeService empService;
	@Autowired
	private SalaryAccountService salaryAccountService;
	@Autowired
	private EmployeeAddressService employeeAddressService;
@PostMapping(value="/employee")
@ResponseBody
	public String addEmployee(@RequestBody EmployeeDTO empDTO) throws Throwable {
	logger.info("employee instance ->"+empDTO);	
	String scMsg = empService.addEmployee(empDTO);
		return scMsg;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter employee details");
////		System.out.println("enter empId");
////		long a = sc.nextInt();// int->Integer
//
//		// auto promotion conncept
//		// auot boxing and auto unoxing
//		System.out.println("enter emp name");
//		String empName = sc.next();
//		System.out.println("enter phone number");
//		String phNumber = sc.next();
//		System.out.println("enter the email");
//		String email = sc.next();
////		Long employeeId, String empName, String designation, Double salary, String phoneNumber,
////		String email, LocalDate doj
//
//		System.out.println("enter designation");
//		String designation = sc.next();
//		System.out.println("enter salary");
//		Double salaray = sc.nextDouble();
//
//		System.out.println("enter date in format dd/MM/YYYY");
//		String date = sc.next();
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDate d = LocalDate.parse(date, dtf);
//		EmployeeDTO empDTO = new EmployeeDTO(empName, designation, salaray, phNumber, email, d);
		

	}

	@GetMapping(value = "/employee/all")
	@ResponseBody
	public List<Employee> viewAllEmployees() {
		// System.out.println("fetching employees");
		List<Employee> list = empService.viewAllEmployees();
		return list;
	}

//@RequestMapping()
	@GetMapping(value = "/employee")
	@ResponseBody
	public Employee viewEmployee(@RequestParam(name = "empId", required = true) Long empId) {
//		System.out.println("fetching employee details");
//		Scanner sc = new Scanner(System.in);
//		System.out.println("enter employee details");
//		System.out.println("enter empId");
//		long a = sc.nextInt();// int->Integer

		Employee list = empService.viewEmployee(empId);
		return list;
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

	@GetMapping(value = "/employees/search/{designation}")
	@ResponseBody
	public List<Employee> searchByDesignation(@PathVariable(name="designation") String designation) {

//		Scanner sc = new Scanner(System.in);
//		String designation = sc.next();
		return empService.searchByDesignation(designation);
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
@PostMapping(value="/bank-details",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
@ResponseBody
	public String addBankDetails(@ModelAttribute SalaryAccountDTO sadto) throws EmployeeManagementException, IOException {
	
		String msg = salaryAccountService.addBankDetails(sadto);
		return msg;
		
//		logger.info(msg);
//		System.out.println("enter empid");
//		Scanner sc = new Scanner(System.in);
//		Long empId = sc.nextLong();
//		System.out.println("enter bank details");
//		System.out.println("enter account number");
//		String accountNo = sc.next();
//		System.out.println("enter ifsc code");
//		String ifsc = sc.next();
//		System.out.println("enter branch name");
//		String branch = sc.next();
//		System.out.println("enter account holder name");
//		String name = sc.next();
//		// String accountNumber, String accountHolderName, String ifsc, String branch,
//		// Long empId
//		SalaryAccountDTO sadto = new SalaryAccountDTO(accountNo, name, ifsc, branch, empId);
//		

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
