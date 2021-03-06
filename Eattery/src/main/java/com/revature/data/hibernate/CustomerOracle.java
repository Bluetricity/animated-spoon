package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Customers;
import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class CustomerOracle implements CustomerDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addCustomer(Customers cus) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(cus);
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
	public Customers getCustomerbyUNandPW(Customers cus) {
		Session s = hu.getSession();
		
		String query = "from Customers where username = :name and password = :password";
		Query<Customers> q = s.createQuery(query, Customers.class);
		q.setParameter("name", cus.getUsername());
		q.setParameter("password", cus.getPassword());
		
		cus = q.uniqueResult();
		s.close();
		
		return cus;
	}
	
	
	@Override
	public Customers getCustomer(Integer cus) {
		Session s = hu.getSession();
		Customers ret = s.get(Customers.class, cus);
		s.close();
		return ret;
	}

	@Override
	public void deleteCustomer(Customers cus) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(cus.getCID());
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
	public void updateCustomer(Customers cus) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(cus.getCID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, CustomerOracle.class);
		} finally {
			s.close();
		}
	}




}
