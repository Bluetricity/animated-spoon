package com.revature.data.hibernate;

import com.revature.beans.Customers;

public interface CustomerDAO {
	public int addCustomer(Customers cus);
	
	public Customers getCustomer(Integer cus);
	
	public void deleteCustomer(Customers cus);
	
	public void updateCustomer(Customers cus);

}
