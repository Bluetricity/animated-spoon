package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.beans.Employee;
import com.revature.data.hibernate.CustomerOracle;
import com.revature.data.hibernate.EmployeeDAO;
import com.revature.data.hibernate.EmployeeOracle;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeOracle EO;

	//Currently not working
	@GetMapping(value="{id}")
	public Employee getCustomer(@PathVariable Integer id) {
		return EO.getEmployee(id);
 
	}
	
	//Currently not working
	@PostMapping
	public Employee addCustomer(@RequestBody Employee g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addCustomer(@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}
