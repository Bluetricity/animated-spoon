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

import com.revature.beans.Menu_Type;
import com.revature.beans.Stock;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class MenuTypeOracle implements MenuTypeDAO{
	@Autowired
	private HibernateUtil hu;

	@Override
	public int addMenuType(Menu_Type mt) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(mt);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, MenuTypeOracle.class);
		} finally {
			s.close();
		}
		return i;
	}

	@Override
	public Set<Menu_Type> getMenuTypes() {
		Session s = hu.getSession();
		String query = "select * from Menu_Type";
		Query<Menu_Type> q = s.createNativeQuery(query, Menu_Type.class);
		List<Menu_Type> ret = q.getResultList();
		s.close();
		return new HashSet<Menu_Type>(ret);
	}

	@Override
	public Menu_Type getMenuType(Integer mt) {
		Session s = hu.getSession();
		Menu_Type ret = s.get(Menu_Type.class, mt);
		s.close();
		return ret;
	}

	@Override
	public void deleteMenuType(Menu_Type mt) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(mt);
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, Menu_Type.class);
		} finally {
			s.close();
		}
		
	}

	@Override
	public void updateMenuType(Menu_Type mt) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(mt.getMTID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, Menu_Type.class);
		} finally {
			s.close();
		}
	}

}
