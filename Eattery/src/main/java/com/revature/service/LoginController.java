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
	
	@PostMapping()
	public User login(String username, String password, HttpSession session) {
		User currentUser = new User();
		Customers cus = new Customers();
		Employee emp = new Employee();
		CustomerDAO cd = new CustomerOracle();
		EmployeeDAO dd = new EmployeeOracle();
		
		cus.setUsername(username);
		cus.setPassword(password);
		emp.setUsername(username);
		emp.setPassword(password);
		currentUser.setCust(cd.getCustomerbyUNandPW(cus));
		currentUser.setEmp(dd.getEmployeebyUNandPW(emp));
		
		return currentUser;
		
	}
}
