package com.revature.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import com.revature.beans.Employee;
import com.revature.beans.ItemTransaction;
import com.revature.data.hibernate.EmployeeDAO;
import com.revature.data.hibernate.TransactionItemsOracle;

@RestController
@CrossOrigin(origins="http://localhost:4200")
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
	
	@GetMapping
	public Set<ItemTransaction> getAllTransactions(){
		return CO.getAllTransactions();
	}
	
	@GetMapping(value="{id}")
	public ItemTransaction getStock(@PathVariable Integer id) {
		return CO.getItemTransaction(id);
	}
	
	//Currently not working
	@PostMapping
	public ItemTransaction addTransaction (@RequestBody ItemTransaction g) {
		System.out.println(g);
		CO.addItemTransaction(g);
		return g;

	}
	@PostMapping(value="/string")
	public String addTransaction (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}
	@PutMapping(value="{id}")
	public ResponseEntity<ItemTransaction> updateTransaction(@PathVariable Integer id, @RequestBody ItemTransaction it){
		if(CO.getItemTransaction(id) == null) {
			return ResponseEntity.status(405).body(null);
		}
		return ResponseEntity.ok(CO.updateItemTransaction(it));
	}
//	@PutMapping("/{tid}")
//	public ItemTransaction updateTransaction(@PathVariable Integer id, @RequestBody ItemTransaction i) {
//		return CO.updateItemTransaction(i);
//	}
}
