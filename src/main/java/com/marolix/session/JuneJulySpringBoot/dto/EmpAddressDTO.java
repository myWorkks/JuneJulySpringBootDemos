package com.marolix.session.JuneJulySpringBoot.dto;

public class EmpAddressDTO {

	
	private String hno;
	private String street;
	private String city;
	private String state;
	private String pincode;
	
	
	
	public EmpAddressDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public EmpAddressDTO(String hno, String street, String city, String state, String pincode) {
		super();
		this.hno = hno;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}


	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
