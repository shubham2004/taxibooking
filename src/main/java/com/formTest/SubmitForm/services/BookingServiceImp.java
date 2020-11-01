package com.formTest.SubmitForm.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formTest.SubmitForm.dao.BookingDao;
import com.formTest.SubmitForm.entities.Booking;

@Service
public class BookingServiceImp implements BookingService
{
	@Autowired
	BookingDao bookingDao;
	
	public String saveBookingService(Booking booking) throws InterruptedException, ExecutionException
	{
		return bookingDao.saveBooking(booking);
	}
	public Booking getBookingService(String name) throws InterruptedException, ExecutionException
	{
		return bookingDao.getBooking(name);
	}
	 public String updateBookingService(Booking booking) throws InterruptedException, ExecutionException
	 {
		 return bookingDao.updateBooking(booking);
	 }
	 public String deleteBookingService(String bookingId)
	 {
		 return bookingDao.deleteBooking(bookingId);
	 }
	 public ArrayList<String> getAllBooking()
	 {
		 return bookingDao.getAllBooking();
	 }
}
