package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Transactionitems;
import com.revature.beans.Menu;
import com.revature.beans.Stock;
import com.revature.beans.Stock_menu;

public interface SaMDAO {
	public void addSaM(Stock_menu SaM);

	public Set<Stock_menu> getSaM();
	
	public Set<Stock_menu> getSaMbyMID(Integer mid);
		
	public void deleteSaM(Stock_menu SaM);
	
	public void deleteSaMbyMID(Menu mid);
	
	public void updateSaM(Stock_menu SaM); 
}
