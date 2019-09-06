package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Transactionitems;
import com.revature.beans.Stock;

public interface TaIDAO {
	public int addTaI(Transactionitems TaI);

	public Set<Transactionitems> getTaI();
	
	public Set<Transactionitems> getTaIbyT(Integer T);
	
	public void deleteTaI(Transactionitems TaI);
	
	public void updateTaI(Transactionitems TaI); 
}