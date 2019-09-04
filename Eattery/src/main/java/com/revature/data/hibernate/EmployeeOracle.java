package com.revature.data.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Customers;
import com.revature.beans.Employee;
import com.revature.util.HibernateUtil;
import com.revature.util.LogUtil;

@Component
public class EmployeeOracle implements EmployeeDAO{
	@Autowired
	private HibernateUtil hu;
	
	@Override
	public int addEmployee(Employee employee) {
		Session s = hu.getSession();
		Transaction t = null;
		Integer i = 0;
		try {
			t = s.beginTransaction();
			i = (Integer) s.save(employee);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
			LogUtil.logException(e, EmployeeOracle.class);
		} finally {
			s.close();
		}
		return i;

	}

	@Override
	public Employee getEmployeebyUNandPW(Employee em) {
		Session s = hu.getSession();
		
		String query = "from Employee where username = :name and password = :password";
		Query<Employee> q = s.createQuery(query, Employee.class);
		q.setParameter("name", em.getUsername());
		q.setParameter("password", em.getPassword());
		
		em = q.uniqueResult();

		return em;
	}
	
	
	@Override
	public Employee getEmployee(Integer em) {
		Session s = hu.getSession();
		Employee ret = s.get(Employee.class, em);
		s.close();
		return ret;
	}
	

	@Override
	public void deleteEmployee(Employee em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.delete(em.getEID());
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, EmployeeOracle.class);
		} finally {
			s.close();
		}
	} 

	@Override
	public void updateEmployee(Employee em) {
		Session s = hu.getSession();
		Transaction t = null;
		try{
			t = s.beginTransaction();
			s.update(em.getEID()); 
			t.commit();
		} catch(Exception e) {
			if(t != null)
				t.rollback();
			LogUtil.logException(e, EmployeeOracle.class);
		} finally {
			s.close();
		}
	}
	
	
}
