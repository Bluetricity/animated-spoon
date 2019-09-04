package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Menu;
import com.revature.beans.Stock;

public interface MenuDAO {
	public int addMenu(Menu menu);
	
	public Menu getMenu(Integer menu);
	
	public Set<Menu> getMenubyIngredient(Stock st);
	
	public Set<Menu> getMenubyQuantity(Stock st);
	
	public Set<Menu> getMenu();
	
	public void deleteMenu(Menu menu);
	
	public void updateMenu(Menu menu);
}
