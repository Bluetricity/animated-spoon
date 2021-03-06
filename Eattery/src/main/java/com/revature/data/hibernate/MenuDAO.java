package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Menu;
import com.revature.beans.Menu_Type;
import com.revature.beans.Stock;

public interface MenuDAO {
	public int addMenu(Menu menu);
	
	public Menu getMenu(Integer menu);
	
	public Set<Menu> getMenubyIngredient(Stock st);
	
	public Set<Menu> getMenubyAvailQuantity();
	
	public Set<Menu> getMenuEmp(Integer mid);
	
	public Set<Menu> getAll();
	
	public void deleteMenu(Menu menu);
	
	public void updateMenu(Menu menu);

	public Set<Menu> getMenuByMenuType(Menu_Type mt);
}
