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
import com.revature.beans.Stock;
import com.revature.data.hibernate.StockOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@RequestMapping(value="/stock")
public class StockController {

	@Autowired
	private StockOracle CO;

	@GetMapping
	public Set<Stock> getStock () {
		//Stock in = (Stock) ac.getBean("Stocks");
		return CO.getStock();//CO.getStock (id);

	}
	
	@GetMapping(value="{id}")
	public Stock getStock (@PathVariable Integer id) {
		return CO.getStock(id);//CO.getStock (id);

	}
	
	//Currently not working
	@PostMapping
	public Stock addStock (@RequestBody Stock g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addStock (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}

}
