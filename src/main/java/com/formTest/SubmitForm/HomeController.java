package com.formTest.SubmitForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Home page is requested");
		return "index.jsp";
	}
	@RequestMapping("result")
	public String booked(HttpServletRequest req)
	{
		String name = req.getParameter("customer_name");
		String phone = req.getParameter("phone_number");
		String email = req.getParameter("email_address");
		String taxi = req.getParameter("taxi");
		String extras = req.getParameter("extras");
		String pickupDate = req.getParameter("pickup_time");
		String pickupPlace = req.getParameter("pickup_place");
		String dropOff = req.getParameter("dropoff_place");
		String comments = req.getParameter("comments");
		
		HttpSession session = req.getSession();
		session.setAttribute("name",name);
		session.setAttribute("taxt",taxi);
		session.setAttribute("date",pickupDate);
		
		return "result.jsp";
	}
}
