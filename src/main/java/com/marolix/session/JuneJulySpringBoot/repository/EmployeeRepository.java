package com.marolix.session.JuneJulySpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marolix.session.JuneJulySpringBoot.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	List<Employee> findByDesignation(String designation);

	Employee findByPhoneNumber(String phnoNumber);

//using query approach to to transaction
//	@Query(value = "SELECT * FROM junejuly_db.emp_details e where e.emp_salary>=40000 and e.emp_salary<=75000  ;", nativeQuery = true)
	//positional parameters
	@Query(value = "SELECT * FROM junejuly_db.emp_details e where e.emp_salary>=?1 and e.emp_salary<=?2  ;", nativeQuery = true)
	List<Employee> findEmployeesDataBetweenSalaraies(Double minSalary,Double maxSalary);
	
	//named paramters approach
	
//	@Query(value = "SELECT * FROM junejuly_db.emp_details e where e.emp_salary>=:min and e.emp_salary<=:max ;", nativeQuery = true)
//	List<Employee> findEmployeesDataBetweenSalaraies(@Param(value="min") Double minSalary,@Param(value="max") Double maxSalaray);
}
