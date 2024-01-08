package com.marolix.session.JuneJulySpringBoot.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.marolix.session.JuneJulySpringBoot.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
