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

import com.revature.beans.ItemTransaction;
import com.revature.data.hibernate.TransactionItemsOracle;
import com.revature.beans.Stock;
import com.revature.beans.Transactionitems;
import com.revature.beans.Stock_menu;
import com.revature.beans.Stock_menuID;
import com.revature.beans.TransactionsitemsID;
import com.revature.data.hibernate.SaMOracle;
import com.revature.data.hibernate.StockOracle;
import com.revature.data.hibernate.TaIOracle;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/transaction")
public class TransactionController {

	@Autowired
	private TransactionItemsOracle CO;
	
	@Autowired
	private StockOracle SO;
	
	@Autowired
	private SaMOracle SMO;
	
	@Autowired
	private TaIOracle TIO;

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
		
		System.out.println(g);
		return g;

	}
	@PostMapping(value="/string")
	public String addTransaction (@RequestBody String g) {
		System.out.println(g);
		
		return g;

	}
	@PutMapping(value="{id}")
	public ResponseEntity<ItemTransaction> updateTransaction(@PathVariable Integer id, @RequestBody ItemTransaction it){
		Set<Transactionitems> tSet;
		Set<Stock_menu> smSet;
		Stock targetStock;
		Double quantity;
		Double amount;
		Double currentQuantity;
		Double newQuantity;
		if(CO.getItemTransaction(id) == null) {
			return ResponseEntity.status(405).body(null);
		}
		CO.updateItemTransaction(it);
		tSet = TIO.getTaIbyT(id);
		for(Transactionitems tItem: tSet) {
			smSet = SMO.getSaMbyMID(tItem.gettaiid().getMID().getMID());
			for(Stock_menu smItem: smSet) {
				targetStock = SO.getStock(smItem.getComposid().getSID().getSID());
				quantity = tItem.getquanity();
				amount = smItem.getAmount();
				currentQuantity = targetStock.getQuantity();
				newQuantity = (double) currentQuantity - (quantity * amount);
				targetStock.setQuantity(newQuantity);
				SO.updateStock(targetStock);
			}
		}
		return ResponseEntity.ok(CO.getItemTransaction(id));
		
	}
//	@PutMapping("/{tid}")
//	public ItemTransaction updateTransaction(@PathVariable Integer id, @RequestBody ItemTransaction i) {
//		return CO.updateItemTransaction(i);
//	}
}
