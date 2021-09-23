package com.dbs.web.mvc;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.User;
import com.dbs.web.repository.CustomerRepository;

@Controller
public class EntryController {
	
	@Autowired
	private CustomerRepository repo;
	@GetMapping
	public String homePage() {
		System.out.println("-----Index jsp-------");
		return "index";
		
	}
	@GetMapping("/login")
	public String loginPage() {
		System.out.println("-----Login jsp-------");
		return "login";
		
	}
	@PostMapping("/login")
	public String Validate(User user,
			Map<String, Customer> map,
			Map<String, String> maperror,
			HttpSession session) 
	{
		System.out.println("validate "+user);
		Optional<Customer> cust = this.repo.findById(user.getEmail());
		if(cust.isPresent())
		{
			Customer customer = cust.get();
			session.setAttribute("cust", customer);
			map.put("customer", customer);
			return "redirect:/dashboard";
			
		}
		maperror.put("error", "Invalid Credentials");
		
		return "redirect:/login?error=Invalid Credentials";	
	}
}
