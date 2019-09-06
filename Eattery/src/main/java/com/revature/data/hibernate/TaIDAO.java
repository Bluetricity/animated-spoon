package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.JoinTransactionandItems;
import com.revature.beans.Stock;

public interface TaIDAO {
	public int addTaI(JoinTransactionandItems TaI);

	public Set<JoinTransactionandItems> getTaI();
	
	public Set<JoinTransactionandItems> getTaIbyT(Integer T);
	
	public void deleteTaI(JoinTransactionandItems TaI);
	
	public void updateTaI(JoinTransactionandItems TaI); 
}
