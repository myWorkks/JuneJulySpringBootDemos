package com.marolix.session.JuneJulySpringBoot.service;

import com.marolix.session.JuneJulySpringBoot.dto.EmpAddressDTO;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;

public interface EmployeeAddressService {

	public String addEmpAddress(Integer empId, EmpAddressDTO dto) throws EmployeeManagementException;
}
