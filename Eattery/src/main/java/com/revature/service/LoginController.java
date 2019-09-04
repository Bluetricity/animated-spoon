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
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.data.hibernate.CustomerOracle;
import com.revature.data.hibernate.EmployeeOracle;
import com.revature.data.hibernate.CustomerDAO;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {

	@Autowired
	CustomerController CC;
	
	@Autowired
	EmployeeController EC;
	
	@Autowired
	CustomerDAO cd;
	
	@Autowired
	EmployeeDAO ed;
	
	//HttpSession session
	
	@PostMapping()
	public User login(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		User currentUser = new User();
		Customers cus = new Customers();
		Employee emp = new Employee();
		
		cus.setUsername(username);
		cus.setPassword(password);
		emp.setUsername(username);
		emp.setPassword(password);
		
		currentUser.setCust(cd.getCustomerbyUNandPW(cus));
		currentUser.setEmp(ed.getEmployeebyUNandPW(emp));
		System.out.println(currentUser.getCust());
		System.out.println(currentUser.getEmp());
		
		return currentUser;
		
	}
}
