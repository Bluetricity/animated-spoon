package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Menu;
import com.revature.beans.Stock;

public interface MenuDAO {
	public int addMenu(Menu Menu);
	
	public Menu getMenu(Menu em);
	
	public Set<Menu> getMenubyIngredient(Stock st);
	
	public Set<Menu> getMenubyQuantity(Stock st);
	
	public void deleteMenu(Menu em);
	
	public void updateMenu(Menu em);
}
