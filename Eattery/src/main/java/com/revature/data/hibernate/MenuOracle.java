package com.revature.data.hibernate;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Locations;
import com.revature.beans.Menu;
import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class MenuOracle implements MenuDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addMenu(Menu Menu) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(Menu);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, MenuOracle.class);
		} finally {
			s.close();
		}
		return i;

	}
	
	@Override
	public Menu getMenu(Menu em) {
		Session s = hu.getSession();
		Menu ret = s.get(Menu.class, em.getMID());
		s.close();
		return ret;
	}
	
	@Override
	public Set<Menu> getMenubyIngredient(Stock st) {
		//TODO Broken: use with care
		Session s = hu.getSession();
		Set<Menu> ret = (Set<Menu>) s.get(Locations.class, st.getSID());
		s.close();
		return ret;
	}

	@Override
	public Set<Menu> getMenubyQuantity(Stock st) {
		//TODO Broken: use with care
		Session s = hu.getSession();
		Set<Menu> ret = (Set<Menu>) s.get(Locations.class, st.getSID());
		s.close();
		return ret;
	}
	

	@Override
	public void deleteMenu(Menu em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(em.getMID());
			t.commit();
		} catch(Exception e) { 
			if(t != null)
				t.rollback();
			LogUtil.logException(e, MenuOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public void updateMenu(Menu em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(em.getMID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, MenuOracle.class);
		} finally {
			s.close();
		}
	}


	
}
