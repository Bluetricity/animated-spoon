package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Transactionitems;
import com.revature.beans.Menu;
import com.revature.beans.Stock;

public interface TaIDAO {
	public void addTaI(Transactionitems TaI);

	public Set<Transactionitems> getTaI();
	
	public Set<Transactionitems> getTaIbyT(Integer T);
	
	public void deleteTaI(Transactionitems TaI);
	
	public void deleteTaIbyMID(Menu mid);
	
	public void updateTaI(Transactionitems TaI); 
}
