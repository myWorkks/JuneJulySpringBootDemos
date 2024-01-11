package com.marolix.session.JuneJulySpringBoot.service;

import com.marolix.session.JuneJulySpringBoot.dto.SalaryAccountDTO;
import com.marolix.session.JuneJulySpringBoot.exception.EmployeeManagementException;

public interface SalaryAccountService {
public String addBankDetails(SalaryAccountDTO dto) throws EmployeeManagementException;
}
