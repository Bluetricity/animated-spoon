package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class StockOracle implements StockDAO{ 
	@Autowired  
	private HibernateUtil hu;
	
	@Override
	public int addStock(Stock Stock) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(Stock);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, StockOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Stock getStock(Stock em) {
		Session s = hu.getSession();
		Stock ret = s.get(Stock.class, em.getSID());
		s.close();
		return ret;
	}

	@Override
	public void deleteStock(Stock em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(em.getSID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, StockOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public void updateStock(Stock em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(em.getSID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, StockOracle.class);
		} finally {
			s.close();
		}
	}
	
	
}
