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

import com.revature.beans.JoinTransactionandItems;
import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class TaIOracle implements TaIDAO{ 
	@Autowired  
	private HibernateUtil hu;
	
	@Override
	public int addTaI(JoinTransactionandItems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(TaI);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, TaIOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Set<JoinTransactionandItems> getTaI() {
		Session s = hu.getSession();
		String query = "from TRANSACTIONITEMS";
		Query<JoinTransactionandItems> q = s.createQuery(query, JoinTransactionandItems.class);
		List<JoinTransactionandItems> ret = q.list();
		s.close();
		return new HashSet<JoinTransactionandItems>(ret);
	}
	
	@Override
	public Set<JoinTransactionandItems> getTaIbyT(Integer T) {
		Session s = hu.getSession();
		String query = "from TRANSACTIONITEMS where TID = :id";
		Query<JoinTransactionandItems> q = s.createQuery(query, JoinTransactionandItems.class);
		q.setParameter("id", T);
		List<JoinTransactionandItems> ret = q.list();
		s.close();
		return new HashSet<JoinTransactionandItems>(ret);
	}
	
	@Override
	public void deleteTaI(JoinTransactionandItems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(TaI.getComposid());
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
	public void updateTaI(JoinTransactionandItems TaI) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(TaI.getComposid());
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
