package com.revature.driver;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.revature.beans.Employee;
import com.revature.data.hibernate.EmployeeOracle;
import com.revature.util.HibernateUtil;

@Component
public class Driver {
	
	private static Logger log = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("Bob");
		e.setUsername("Builder");
		e.setPassword("Can");
		e.setTitle("Janitor");
		
		EmployeeOracle EH = new EmployeeOracle();
		EH.addEmployee(e);
	}

	private static void insertion() {
		Employee e = new Employee();
		e.setName("Bob");
		e.setUsername("Builder");
		e.setPassword("Can");
		e.setTitle("Janitor");
		
//		Session s = hu.getSession();
//		Transaction tx = null;
//		try {
//			tx = s.beginTransaction();
//			s.save(e);
//			tx.commit();
//		} catch (Exception E) {
//			tx.rollback();
//			E.printStackTrace();
//		} finally {
//			s.close();
//		}
	}
	
	
}
