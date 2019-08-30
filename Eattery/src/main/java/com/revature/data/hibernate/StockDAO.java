package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Stock;

public interface StockDAO {
	public int addStock(Stock st);
	
	public Set<Stock> getStock();
	
	public Stock getStock(Integer st);
	
	public void deleteStock(Stock st);
	
	public void updateStock(Stock st); 
}
