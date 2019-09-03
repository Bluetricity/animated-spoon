package com.revature.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Customers;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	CustomerController CC;
	
	@Autowired
	EmployeeController EC;
	
	@PostMapping()
	public Customers getCustomer(String username, String password, HttpSession session) {		
		CC.addCustomer();
		
		EC
		
		return 
		
	}
}
