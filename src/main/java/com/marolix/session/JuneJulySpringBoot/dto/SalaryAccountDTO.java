package com.marolix.session.JuneJulySpringBoot.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
public class SalaryAccountDTO {
	private String accountNumber;
	private String accountHolderName;
	private String ifsc;
	private String branch;
	private Long empId;
	private MultipartFile passbook;
	
	public MultipartFile getPassbook() {
		return passbook;
	}


	public void setPassbook(MultipartFile passbook) {
		this.passbook = passbook;
	}


	public SalaryAccountDTO(String accountNumber, String accountHolderName, String ifsc, String branch, Long empId) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.ifsc = ifsc;
		this.branch = branch;
		this.empId = empId;
	}
	
	
	public SalaryAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	
	
}
