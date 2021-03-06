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
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class TaIOracle implements TaIDAO{ 
	@Autowired  
	private HibernateUtil hu;
	
	@Override
	public void addTaI(Transactionitems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			s.save(TaI);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, TaIOracle.class);
		} finally {
			s.close();
		}
	}

	@Override
	public Set<Transactionitems> getTaI() {
		Session s = hu.getSession();
		String query = "from Transactionitems";
		Query<Transactionitems> q = s.createQuery(query, Transactionitems.class);
		List<Transactionitems> ret = q.list();
		s.close();
		return new HashSet<Transactionitems>(ret);
	}
	
	@Override
	public Set<Transactionitems> getTaIbyT(Integer T) {
		Session s = hu.getSession();
		String query = "from Transactionitems where TID = :id";
		Query<Transactionitems> q = s.createQuery(query, Transactionitems.class);
		q.setParameter("id", T);
		List<Transactionitems> ret = q.list();
		s.close();
		return new HashSet<Transactionitems>(ret);
	}
	
	@Override
	public void deleteTaI(Transactionitems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(TaI.gettaiid());
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
	public void deleteTaIbyMID(Menu mid) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			String query = "delete from Transactionitems where MID = :name";
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
	public void updateTaI(Transactionitems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(TaI.gettaiid());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, TaIOracle.class);
		} finally {
			s.close();
		}
	}


	
	
}
