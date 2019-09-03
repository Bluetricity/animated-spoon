package com.revature.data.hibernate;

import com.revature.beans.Customers;
import com.revature.beans.Employee;

public interface EmployeeDAO {
	public int addEmployee(Employee employee);
	
	public Employee getEmployeebyUNandPW(Employee em);
	
	public Employee getEmployee(Integer em);
	
	public void deleteEmployee(Employee em);
	
	public void updateEmployee(Employee em);
}
