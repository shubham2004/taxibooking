package com.formTest.SubmitForm.entities;

public class Booking {
	String custName; 
	String phone; 
	String email; 
	String taxi; 
	String extras; 
	String pickupDate; 
	String pickupPlace; 
	String dropOff;
	String comments;
	String bookingId;
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getName() {
		return custName;
	}
	public void setName(String name) {
		this.custName = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTaxi() {
		return taxi;
	}
	public void setTaxi(String taxi) {
		this.taxi = taxi;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public String getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(String pickupDate) {
		this.pickupDate = pickupDate;
	}
	public String getPickupPlace() {
		return pickupPlace;
	}
	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}
	public String getDropOff() {
		return dropOff;
	}
	public void setDropOff(String dropOff) {
		this.dropOff = dropOff;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Booking [name=" + custName + ", phone=" + phone + ", email=" + email + ", taxi=" + taxi + ", extras="
				+ extras + ", pickupDate=" + pickupDate + ", pickupPlace=" + pickupPlace + ", dropOff=" + dropOff
				+ ", comments=" + comments + ", bookingId=" + bookingId + "]";
	}
	
}
