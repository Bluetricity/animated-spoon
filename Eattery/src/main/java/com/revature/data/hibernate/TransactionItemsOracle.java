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

import com.revature.beans.ItemTransaction;
import com.revature.beans.Locations;
import com.revature.beans.Menu;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class TransactionItemsOracle implements TransactionDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addItemTransaction(ItemTransaction IT) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(IT);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, TransactionItemsOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public ItemTransaction getItemTransaction(Integer IT) {
		Session s = hu.getSession();
		ItemTransaction ret = s.get(ItemTransaction.class, IT);
		s.close();
		return ret;
	}

	@Override
	public Set<ItemTransaction> getItemTransactionbyTransaction(ItemTransaction IT) {
		Session s = hu.getSession();
		Set<ItemTransaction> ret = (Set<ItemTransaction>) s.get(Locations.class, IT.getTID());
		s.close();
		return ret;
	}
	
	@Override
	public void deleteItemTransaction(ItemTransaction IT) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(IT.getTID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, TransactionItemsOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public ItemTransaction updateItemTransaction(ItemTransaction IT) { 
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(IT);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, TransactionItemsOracle.class);
		} finally {
			s.close();
		}
		return IT;
	}

	@Override
	public Set<ItemTransaction> getAllTransactions() {
		Session s = hu.getSession();
		String query = "from ItemTransaction";
		Query<ItemTransaction> q = s.createQuery(query, ItemTransaction.class);
		List<ItemTransaction> ret = q.list();
		s.close();
		return new HashSet<ItemTransaction>(ret);
	}

	
	
	
}
