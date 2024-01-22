package com.marolix.session.JuneJulySpringBoot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.session.JuneJulySpringBoot.dto.EmpAddressDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.entity.EmployeeAddress;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;
import com.marolix.session.JuneJulySpringBoot.repository.EmployeeAddressRepository;
import com.marolix.session.JuneJulySpringBoot.repository.EmployeeRepository;

@Service(value = "empAddressServiceImpl")
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

	@Autowired
	private EmployeeAddressRepository employeeAddressRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public String addEmpAddress(Integer empId, EmpAddressDTO dto) throws EmployeeManagementException {

		Optional<Employee> optEmp = employeeRepository.findById(empId.longValue());

		Employee emp = optEmp
				.orElseThrow(() -> new EmployeeManagementException("No employee found with empid " + empId));
		EmployeeAddress empAddress = new EmployeeAddress();

		empAddress.setHno(dto.getHno());
		empAddress.setStreet(dto.getStreet());
		empAddress.setCity(dto.getCity());
		empAddress.setState(dto.getState());
		empAddress.setPincode(dto.getPincode());
		// emp.setEmployeeId(null);
		// empAddress.setEmployee(emp);

//		return employeeAddressRepository.save(empAddress).getAddressId().toString();

		List<EmployeeAddress> adList = new ArrayList<EmployeeAddress>();

		adList.add(empAddress);

		emp.setEmployeeAddresses(adList);

		return employeeRepository.save(emp).getEmployeeAddresses().get(0).getAddressId().toString();
	}

}
