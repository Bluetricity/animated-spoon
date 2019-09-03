package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Customers;
import com.revature.beans.Employee;
import com.revature.beans.Locations;
import com.revature.data.hibernate.CustomerOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerOracle CO;

	//public ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	
	@GetMapping(value="{id}")
	public Customers getCustomer(@PathVariable Integer id) {		
		return CO.getCustomer(id);
		//return null;
	}
	
	//Currently not working
	@PostMapping
	public Customers addCustomer(@RequestBody Customers g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addCustomer(@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}
