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
@RequestMapping(value="/genres")
public class GenreController {
	@Autowired
	private EmployeeDAO gd; 
	@Autowired
	private CustomerOracle CO;
	
	
//	@GetMapping
//	public Set<Employee> getAll(){
//		return gd.getEmployee();
//	}
	
//	@GetMapping("{steve}")
//	public Employee getEmployee(@PathVariable("steve") Integer bob) {
//		return gd.getEmployee();
//	}
	
	@GetMapping
	public Customers testsEmployee() {
		Customers a = CO.getCustomer(1);
		System.out.println(a);
		
		return a;
		//Integer i = gd.addEmployee(g);
		//return gd.getEmployee(g);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee g) {
		System.out.println(g);
		
		return null;
		//Integer i = gd.addEmployee(g);
		//return gd.getEmployee(g);
	}

}
