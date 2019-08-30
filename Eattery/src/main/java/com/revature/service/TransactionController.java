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


import com.revature.beans.Employee;
import com.revature.beans.ItemTransaction;
import com.revature.data.hibernate.EmployeeDAO;
import com.revature.data.hibernate.TransactionItemsOracle;

@RestController
@RequestMapping(value="/transaction")
public class TransactionController {

	@Autowired
	private TransactionItemsOracle CO;

//	public ApplicationContext ac;
	
//	@GetMapping(value="{id}")
//	public ItemTransaction getTransaction (@PathVariable Integer id) {
//		ItemTransaction in = (ItemTransaction) ac.getBean("Transactions");
//		return CO.getItemTransaction (in);
//
//	}
	
	//Currently not working
	@PostMapping
	public ItemTransaction addTransaction (@RequestBody ItemTransaction g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addTransaction (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}