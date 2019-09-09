package com.revature.service;

import java.util.HashSet;
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


import com.revature.beans.Employee;
import com.revature.beans.Transactionitems;
import com.revature.beans.Menu;
import com.revature.beans.Stock_menu;
import com.revature.data.hibernate.MenuOracle;
import com.revature.data.hibernate.SaMOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/SaM")
public class SaMController {

	@Autowired
	private SaMOracle SMO;
	
	@GetMapping
	public Set<Stock_menu> getMenuCust(){	
		return SMO.getSaM();
	}
	
	@GetMapping(value="{id}")
	public Menu getMenu (@PathVariable Integer id) {
	//	This is the TransactionID.
		return null;//CO.getMenu (in);

	}
	
	@PostMapping
	public Stock_menu addMenu (@RequestBody Stock_menu SaM) {
		System.out.println(SaM);
		System.out.println("Hello");
		SMO.addSaM(SaM);
		return SaM;

	}
	
	
	
	@PostMapping(value="/string")
	public String addMenu (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}
	
	

}
