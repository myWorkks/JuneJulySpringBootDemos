package com.marolix.session.JuneJulySpringBoot.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marolix.session.JuneJulySpringBoot.dto.SalaryAccountDTO;
import com.marolix.session.JuneJulySpringBoot.entity.Employee;
import com.marolix.session.JuneJulySpringBoot.entity.SalaryAccount;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;
import com.marolix.session.JuneJulySpringBoot.repository.EmployeeRepository;
import com.marolix.session.JuneJulySpringBoot.repository.SalaryAccountRepository;

@Service(value = "salaryAcntService")
public class SalaryAccountServiceImpl implements SalaryAccountService {

	@Autowired
	private SalaryAccountRepository salaryAccountRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public String addBankDetails(SalaryAccountDTO dto) throws EmployeeManagementException, IOException {
		;

		Optional<Employee> optEmp = employeeRepository.findById(dto.getEmpId());
		Employee emp = optEmp
				.orElseThrow(() -> new EmployeeManagementException("no employee found with id " + dto.getEmpId()));

		SalaryAccount newSalaryAccount = new SalaryAccount();// empty
		newSalaryAccount.setAccountNumber(dto.getAccountNumber());
		newSalaryAccount.setAccountHolderName(dto.getAccountHolderName());
		newSalaryAccount.setIFSC(dto.getIfsc());
		newSalaryAccount.setBranch(dto.getBranch());
		// all values except actId
byte[] bytes=		dto.getPassbook().getBytes();
		newSalaryAccount.setPassbookImage(bytes);
		newSalaryAccount.setEmployee(emp);
		SalaryAccount sa = salaryAccountRepository.save(newSalaryAccount);
		return "account added successfully with id " + sa.getAcId() + "for emp id " + dto.getEmpId();
	}

}
