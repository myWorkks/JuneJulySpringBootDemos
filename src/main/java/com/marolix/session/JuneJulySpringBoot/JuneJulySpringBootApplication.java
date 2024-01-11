package com.marolix.session.JuneJulySpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.marolix.session.JuneJulySpringBoot.controller.EmployeeController;

@SpringBootApplication
//@enableAutoConfiguration
//@Configuration
//CpmponentScan
public class JuneJulySpringBootApplication {

	public static void main(String[] args) throws Throwable {
		ConfigurableApplicationContext context = SpringApplication.run(JuneJulySpringBootApplication.class, args);
		EmployeeController ec = context.getBean(EmployeeController.class);

		// ec.addEmployee();
		// ec.viewAllEmployees();
		// ec.viewEmployee();
		// ec.deleEMployeeWithEMpID();
		// ec.deleteAllEMployees();
		// ec.searchByDesignation();
		// ec.filterEmployessBySalrayRange();
		// ec.filterByDoj();
		// ec.fectchSpecifiedColumns();
		// ec.updateEMployeeSalaray();
		ec.addBankDetails();
	}

}
