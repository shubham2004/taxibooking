package com.formTest.SubmitForm.controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.formTest.SubmitForm.entities.Booking;
import com.formTest.SubmitForm.entities.Email;
import com.formTest.SubmitForm.entities.Passangers;
import com.formTest.SubmitForm.entities.SessionEntities;
import com.formTest.SubmitForm.services.BookingService;
import com.formTest.SubmitForm.services.MailService;
import com.formTest.SubmitForm.services.MailServiceImp;
import com.formTest.SubmitForm.services.PassangerServices;

@Controller
public class FormController {
	
	@Autowired
	private PassangerServices passangerService;
	
	@Autowired
	private SessionEntities sessionEntities;
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/")
	public String home(HttpServletRequest req)
	{
		System.out.println("Home page is requested");
		HttpSession session=req.getSession();
		session.setAttribute("msg","");
		
		return "login.jsp";
	}
	
	
	
	
	@PostMapping(value="addCust")
	public String addCustomer(HttpServletRequest req)
	{
		MailService mailService=new MailServiceImp();
		Email email = new Email();
		email.setFrom("shubhamgupta20041998@gmail.com");
		email.setSubject("Welcome to our family");
		email.setTo("shubhamgupta20041998@gmail.com");
		email.setMessageText("We are glad to add you to our ever growing family and hope to surve you well");
		//mailService.sendMail(email);
		
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		String passangerId = String.format("%06d", number);
		Passangers passangers = new Passangers();
		passangers.setName(req.getParameter("uname"));
		passangers.setPhoneNumber(req.getParameter("mnumber"));
		passangers.setEmail(req.getParameter("email"));
		passangers.setPassangerId(passangerId);
		passangers.setPassword(req.getParameter("pass"));
		System.out.println(passangers);
		try {
			if(passangerService.getPassangerDetails(passangers.getEmail())!=null)
			{
				HttpSession session=req.getSession();
				session.setAttribute("msg","Email is already registered!");
				return "login.jsp";
			}
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			passangerService.savePassangerDetails(passangers);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		HttpSession session=req.getSession();
		session.setAttribute("msg","You have been successfully enrolled please login!");
		return "login.jsp";
	}
	
	
	@PostMapping("logincust")
	public String loginCustomer(HttpServletRequest req)
	{
		try 
		{
			Passangers passanger = passangerService.getPassangerDetails(req.getParameter("email"));
			
			if(passanger==null)
			{
				HttpSession session=req.getSession();
				session.setAttribute("msg","email or password is wrong, please try again!");
				return "login.jsp";
				
			}
			HttpSession session=req.getSession();
			session.setAttribute("passanger",passanger.getName());
			sessionEntities.setPassanger(passanger);
			return "dashboard.jsp";
		} 
		catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HttpSession session=req.getSession();
		session.setAttribute("msg","email or password is wrong, please try again!");
		return "login.jsp";
		
	}
	
	@PostMapping("newBooking")
	public String addNewBooking(HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		session.setAttribute("email",sessionEntities.getPassanger().getEmail());
		session.setAttribute("mnumber",sessionEntities.getPassanger().getPhoneNumber());
		session.setAttribute("name",sessionEntities.getPassanger().getName());
		
		return "booking.jsp";
	}
	
	@RequestMapping("result")
	public String booked(HttpServletRequest req)
	{
		String custName = req.getParameter("customer_name");
		String mobileNumber = req.getParameter("phone_number");
		String email = req.getParameter("email_address");
		String taxi = req.getParameter("taxi");
		String extras = req.getParameter("extras");
		String pickupDate = req.getParameter("pickup_time");
		String pickupPlace = req.getParameter("pickup_place");
		String dropOff = req.getParameter("dropoff_place");
		String comments = req.getParameter("comments");
		
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
		String bookingId = String.format("%06d", number);
		Booking booking = new Booking();
		booking.setName(custName);
		booking.setPhone(mobileNumber);
		booking.setEmail(email);
		booking.setTaxi(taxi);
		booking.setExtras(extras);
		booking.setPickupDate(pickupDate);
		booking.setPickupPlace(pickupPlace);
		booking.setDropOff(dropOff);
		booking.setComments(comments);
		booking.setBookingId(bookingId);
		booking.setPasssangerId(sessionEntities.getPassanger().getPassangerId());
		try {
			bookingService.saveBookingService(booking);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("name",custName);
		session.setAttribute("taxt",taxi);
		session.setAttribute("date",pickupDate);
		
		return "result.jsp";
	}
	
	@PostMapping("backToDashBoard")
	public String backToDashBoard(HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		session.setAttribute("passanger",sessionEntities.getPassanger().getName());
		return "dashboard.jsp";
	}
	
	@GetMapping("bookingHistory")
	public ModelAndView getCustomerBooking()
	{
		
		ArrayList<Booking> list = bookingService.getAllBooking();
        //return back to index.jsp
        ModelAndView model = new ModelAndView("BookingHistory.jsp");
        model.addObject("lists", list);

        return model;
	}
	
}
