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

import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class StockOracle implements StockDAO{ 
	@Autowired  
	private HibernateUtil hu;
	
	@Override
	public int addStock(Stock st) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(st);
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
	public Set<Stock> getStock() {
		Session s = hu.getSession();
		String query = "from Stock";
		Query<Stock> q = s.createQuery(query, Stock.class);
		List<Stock> ret = q.list();
		s.close();
		return new HashSet<Stock>(ret);
	}
	
	@Override
	public Stock getStock(Integer st) {
		Session s = hu.getSession();
		Stock ret = s.get(Stock.class, st);
		s.close();
		return ret;
	}

	@Override
	public void deleteStock(Stock st) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(st.getSID());
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
	public void updateStock(Stock st) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(st);
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
