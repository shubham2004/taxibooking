package com.formTest.SubmitForm.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.formTest.SubmitForm.entities.Booking;

public interface BookingService 
{
	public String saveBookingService(Booking booking) throws InterruptedException, ExecutionException;
	public Booking getBookingService(String name) throws InterruptedException, ExecutionException;
	 public String updateBookingService(Booking booking) throws InterruptedException, ExecutionException;
	 public String deleteBookingService(String bookingId);
	 public ArrayList<Booking> getAllBooking();
}
