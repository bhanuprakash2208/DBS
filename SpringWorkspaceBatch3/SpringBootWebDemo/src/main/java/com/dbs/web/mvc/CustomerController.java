package com.dbs.web.mvc;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class CustomerController {
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session)
	{
		if(session.getAttribute("cust") == null)
		{
			return "redirect:/login";
		}
		System.out.println("dashboard");
		return "customer";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{
		session.removeAttribute("cust") ;
		session.invalidate();
		return "redirect:/login";
	}
	@GetMapping("/invoice")
	public String invoices()
	{
		return "invoices";
	}
	
}
