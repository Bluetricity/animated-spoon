package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.beans.Locations;
import com.revature.beans.Employee;
import com.revature.data.hibernate.LocationOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@RequestMapping(value="/location")
public class LocationController {

	@Autowired
	private LocationOracle CO;

	
	@GetMapping(value="{id}")
	public Locations getLocation (@PathVariable Integer id) {
		//Locations in = (Locations) ac.getBean("Locations");
		return null;// CO.getLocation (in);

	}
	
	//Currently not working
	@PostMapping
	public Locations addLocation (@RequestBody Locations g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addLocation (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}
