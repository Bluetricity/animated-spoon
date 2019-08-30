package com.revature.data.hibernate;

import java.util.Set;

import com.revature.beans.Customers;
import com.revature.beans.Locations;

public interface LocationDAO {
	public int addLocation(Locations Location);
	
	public Locations getLocation(Integer loc); 
	
	public Set<Locations> getLocationbyCustomer(Customers c);
	
	public void deleteLocation(Locations loc);
	
	public void updateLocation(Locations loc);


}
