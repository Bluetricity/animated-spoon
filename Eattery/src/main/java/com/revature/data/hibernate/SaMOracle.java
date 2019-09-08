package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Transactionitems;
import com.revature.beans.Menu;
import com.revature.beans.Stock;
import com.revature.beans.Stock_menu;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class SaMOracle implements SaMDAO{ 
	@Autowired  
	private HibernateUtil hu;
	
	@Override
	public int addSaM(Stock_menu SaM) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(SaM);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, SaMOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Set<Stock_menu> getSaM() {
		Session s = hu.getSession();
		String query = "from Stock_menu";
		Query<Stock_menu> q = s.createQuery(query, Stock_menu.class);
		List<Stock_menu> ret = q.list();
		s.close();
		return new HashSet<Stock_menu>(ret);
	}
	
	@Override
	public void deleteSaM(Stock_menu SaM) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(SaM.getComposid());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, SaMOracle.class);
		} finally {
			s.close();
		}
	} 

	public void deleteSaMbyMID(Menu mid) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			String query = "delete from Stock_menu where MID = :name";
			Query q = s.createQuery(query);
			q.setParameter("name", mid.getMID());
			q.executeUpdate();
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, TaIOracle.class);
		} finally {
			s.close();
		}
	}
	
	@Override
	public void updateSaM(Stock_menu SaM) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(SaM.getComposid());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, SaMOracle.class);
		} finally {
			s.close();
		}
	}


	
	
}
