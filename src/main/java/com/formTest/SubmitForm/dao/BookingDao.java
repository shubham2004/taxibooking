package com.formTest.SubmitForm.dao;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.formTest.SubmitForm.entities.Booking;

public interface BookingDao {
	public String saveBooking(Booking booking) throws InterruptedException, ExecutionException;
	public Booking getBooking(String name) throws InterruptedException, ExecutionException;
	 public String updateBooking(Booking booking) throws InterruptedException, ExecutionException;
	 public String deleteBooking(String bookingId);
	 public ArrayList<String> getAllBooking();
}
