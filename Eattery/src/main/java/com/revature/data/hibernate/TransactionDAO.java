package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.ItemTransaction;

public interface TransactionDAO {
	public int addItemTransaction(ItemTransaction IT);
	
	public ItemTransaction getItemTransaction(Integer IT);
	
	public Set<ItemTransaction> getItemTransactionbyTransaction (ItemTransaction IT);
	
	public Set<ItemTransaction> getAllTransactions();
	
	public void deleteItemTransaction(ItemTransaction IT);
	
	public ItemTransaction updateItemTransaction(ItemTransaction IT);   
}
