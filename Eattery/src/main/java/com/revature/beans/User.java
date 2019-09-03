package com.revature.beans;

import com.revature.beans.Customers;
import com.revature.beans.Employee;

public class User {
	private Customers cust;
	private Employee emp;
	
	public User() {
		super();
	}
	public Customers getCust() {
		return cust;
	}
	public void setCust(Customers cust) {
		this.cust = cust;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}

}
