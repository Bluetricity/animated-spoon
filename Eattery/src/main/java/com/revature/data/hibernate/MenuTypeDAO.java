package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Menu_Type;

public interface MenuTypeDAO {
	public int addMenuType(Menu_Type mt);
	
	public Set<Menu_Type> getMenuTypes();
	
	public Menu_Type getMenuType(Integer mt);
	
	public void deleteMenuType(Menu_Type mt);
	
	public void updateMenuType(Menu_Type mt);
}
