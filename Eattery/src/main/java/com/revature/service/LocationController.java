package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Customers;
import com.revature.beans.Locations;
import com.revature.data.hibernate.LocationOracle;

@RestController
@RequestMapping(value="/location")
@CrossOrigin(origins="http://localhost:4200")
public class LocationController {

	@Autowired
	private LocationOracle CO;

	
	@GetMapping(value="{id}")
	public Set<Locations> getLocationbyCustomer(@PathVariable Integer id) {
		Customers cust = new Customers();
		cust.setCID(id);
		//Locations in = (Locations) ac.getBean("Locations");
		return CO.getLocationbyCustomer(cust);// CO.getLocation (in);

	}
	
	//Currently not working
	@PostMapping
	public Locations addLocation (@RequestBody Locations g) {
		System.out.println(g);
		g.setLID(CO.addLocation(g));
		return g;

	}
	@PostMapping(value="/string")
	public String addLocation (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}
