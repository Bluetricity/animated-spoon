package com.revature.data.hibernate;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Customers;
import com.revature.beans.Locations;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class LocationOracle implements LocationDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addLocation(Locations Locations) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(Locations);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, LocationOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Locations getLocation(Locations em) {
		Session s = hu.getSession();
		Locations ret = s.get(Locations.class, em.getLID());
		s.close();
		return ret;
	}
	
	@Override
	public Set<Locations> getLocationbyCustomer(Customers c) {
		//TODO, Uncertain if this is valid Hibernate code
		
		Session s = hu.getSession();
		Set<Locations> ret = (Set<Locations>) s.get(Locations.class, c.getCID());
		s.close();
		return ret;
	}

	@Override
	public void deleteLocation(Locations em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(em.getLID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, LocationOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public void updateLocation(Locations em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(em.getLID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, LocationOracle.class);
		} finally {
			s.close();
		}
	}
	
	
}
