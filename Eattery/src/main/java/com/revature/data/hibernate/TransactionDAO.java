package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.ItemTransaction;

public interface TransactionDAO {
	public int addItemTransaction(ItemTransaction ItemTransaction);
	
	public ItemTransaction getItemTransaction(ItemTransaction em);
	
	public Set<ItemTransaction> getItemTransactionbyTransaction (ItemTransaction in);
	
	public void deleteItemTransaction(ItemTransaction em);
	
	public void updateItemTransaction(ItemTransaction em);   
}
