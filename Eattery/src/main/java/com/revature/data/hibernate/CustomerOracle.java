package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Customers;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class CustomerOracle implements CustomerDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addCustomer(Customers Customers) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(Customers);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, CustomerOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Customers getCustomer(int em) {
		Session s = hu.getSession();
		Customers ret = s.get(Customers.class, em);
		s.close();
		return ret;
	}

	@Override
	public void deleteCustomer(Customers em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(em.getCID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, CustomerOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public void updateCustomer(Customers em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(em.getCID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, CustomerOracle.class);
		} finally {
			s.close();
		}
	}

	@Override
	public Customers getCustomer(Customers em) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
