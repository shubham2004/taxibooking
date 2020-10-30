package com.formTest.SubmitForm.entities;

public class Passangers {
	
	String name;
	String PassangerId;
	String email;
	String phoneNumber;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassangerId() {
		return PassangerId;
	}
	public void setPassangerId(String passangerId) {
		PassangerId = passangerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Passangers [name=" + name + ", PassangerId=" + PassangerId + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", password=" + password + "]";
	}
	
	
}
