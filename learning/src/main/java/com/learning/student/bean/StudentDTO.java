package com.learning.student.bean;

import javax.validation.constraints.NotBlank;

import com.learning.shared.bean.CommonDTOBean;

public class StudentDTO extends CommonDTOBean{
	
	@NotBlank(message = "Name should not be blank or null")
	private String name;
	
	@NotBlank(message = "Email should not be blank or null")
	private String email;
	
	@NotBlank(message = "Address should not be blank or null")
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
	
}