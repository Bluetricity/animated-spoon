package com.revature.data.hibernate;

import com.revature.beans.Stock;

public interface StockDAO {
	public int addStock(Stock Stock);
	
	public Stock getStock(Stock em);
	
	public void deleteStock(Stock em);
	
	public void updateStock(Stock em); 
}
