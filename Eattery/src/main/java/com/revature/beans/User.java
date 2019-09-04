package com.revature.beans;

import com.revature.beans.Customers;
import com.revature.beans.Employee;

public class User {
	private Customers customer;
	private Employee employee;
	
	public User() {
		super();
	}
	public Customers getCust() {
		return customer;
	}
	public void setCust(Customers cust) {
		this.customer = cust;
	}
	public Employee getEmp() {
		return employee;
	}
	public void setEmp(Employee emp) {
		this.employee = emp;
	}

}
