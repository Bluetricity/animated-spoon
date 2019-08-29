package com.revature.data.hibernate;

import com.revature.beans.Customers;

public interface CustomerDAO {
	public int addCustomer(Customers Customer);
	
	public Customers getCustomer(Customers em);
	
	public void deleteCustomer(Customers em);
	
	public void updateCustomer(Customers em);

	Customers getCustomer(int em);
}
