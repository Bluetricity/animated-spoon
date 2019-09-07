package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Locations;
import com.revature.beans.Menu;
import com.revature.beans.Menu_Type;
import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class MenuOracle implements MenuDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addMenu(Menu menu) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(menu);
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
	public Menu getMenu(Integer menu) {
		Session s = hu.getSession();
		Menu ret = s.get(Menu.class, menu);
		s.close();
		return ret;
	}
	
	@Override
	public Set<Menu> getMenubyIngredient(Stock st) {
		//Uncertain if this is going to work, hope and pray with me.
		Session s = hu.getSession();
		
		String query = "from Menu a inner join Stock_Menu b on a.MID = b.MID inner join Stock c on b.SID = c.SID where QUANTITY_STORED = :in";
		Query<Menu> q = s.createQuery(query, Menu.class);
		q.setParameter("in", st.getQuantity());
		List<Menu> ret = q.getResultList();
		s.close();
		
		return new HashSet<Menu>(ret);
	}

	@Override
	public Set<Menu> getMenubyAvailQuantity() {
		Session s = hu.getSession();
		 
		//This query looks inside every menu item and then checks the amount of 
		//ingredients needed and checks to see if there's proper quantity for every 
		String query = "SELECT * FROM (SELECT MID, COUNT(MID) as ReadyIngedients " + 
				"FROM (SELECT * FROM STOCK_MENU NATURAL JOIN STOCK " + 
				"WHERE AMOUNT <= QUANTITY_STORED) GROUP BY MID) Natural join " + 
				"(SELECT MID, COUNT(MID) AS NumofIngedients FROM Stock_Menu GROUP BY MID) " +
				"NATURAL JOIN MENU Where ReadyIngedients = NumofIngedients";
		NativeQuery<Menu> q = s.createNativeQuery(query, Menu.class);
		List<Menu> ret = q.getResultList();
		s.close();
		
		return new HashSet<Menu>(ret);
	}
	
	@Override
	public Set<Menu> getMenuByMenuType(Menu_Type mt){
		Session s = hu.getSession();
		
		String query = "SELECT * FROM (SELECT MID, COUNT(MID) as ReadyIngedients " + 
				"FROM (SELECT * FROM STOCK_MENU NATURAL JOIN STOCK " + 
				"WHERE AMOUNT <= QUANTITY_STORED) GROUP BY MID) Natural join " + 
				"(SELECT MID, COUNT(MID) AS NumofIngedients FROM Stock_Menu GROUP BY MID) " +
				"NATURAL JOIN MENU Where ReadyIngedients = NumofIngedients AND MTID =:in";
		Query<Menu> q = s.createNativeQuery(query, Menu.class);
		q.setParameter("in", mt.getMTID());
		List<Menu> ret = q.getResultList();
		s.close();
		return new HashSet<Menu>(ret);
	}
	@Override
	public void deleteMenu(Menu menu) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(menu.getMID());
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
	public void updateMenu(Menu menu) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(menu.getMID());
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
	public Set<Menu> getMenu() {
		// TODO Auto-generated method stub
		Session s = hu.getSession();
		String query = "from Menu";
		Query<Menu> q = s.createQuery(query, Menu.class);
		List<Menu> ret = q.list();
		s.close();
		return new HashSet<Menu>(ret);
	}


	
}
