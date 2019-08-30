package com.revature.driver;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Customers;
import com.revature.beans.Employee;
import com.revature.data.hibernate.CustomerOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerOracle CO;

	
	@GetMapping(value="{id}")
	public Customers getCustomer(@PathVariable Integer id) {
		return CO.getCustomer(id);

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
