package com.formTest.SubmitForm.services;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formTest.SubmitForm.dao.BookingDao;
import com.formTest.SubmitForm.entities.Booking;
import com.formTest.SubmitForm.entities.SessionEntities;

@Service
public class BookingServiceImp implements BookingService
{
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	SessionEntities sessionEntities;
	
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
	 public ArrayList<Booking> getAllBooking()
	 {
		 ArrayList<Booking> finalList = new ArrayList<Booking>();
		 ArrayList<Booking> list =  bookingDao.getAllBooking();
		 for(Booking booking : list)
		 {
			 if(booking.getPasssangerId().equals(sessionEntities.getPassanger().getPassangerId()))
			 {
				 finalList.add(booking);
			 }
		 }
		 System.out.println(finalList);
		 return finalList;
	 }
}
