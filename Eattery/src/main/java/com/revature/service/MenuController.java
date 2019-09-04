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
import com.revature.beans.Menu;
import com.revature.data.hibernate.MenuOracle;
import com.revature.data.hibernate.EmployeeDAO;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/menu")
public class MenuController {

	@Autowired
	private MenuOracle CO;

	
	@GetMapping
	public Set<Menu> getMenu(){
		
		
		return CO.getMenubyAvailQuantity();
	}
	
	@GetMapping(value="{id}")
	public Menu getMenu (@PathVariable Integer id) {
//		Menu in = (Menu) ac.getBean("Menus");
		return null;//CO.getMenu (in);

	}
	
	//Currently not working
	@PostMapping
	public Menu addMenu (@RequestBody Menu g) {
		System.out.println(g);
		
		return g;

	}
	@PostMapping(value="/string")
	public String addMenu (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}
	
	

}
