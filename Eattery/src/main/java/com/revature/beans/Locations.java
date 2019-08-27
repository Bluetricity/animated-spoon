package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Locations {
	//@ManyToOne(fetch=FetchType.EAGER)
	Customers CID;
	String Address;
	
	public Locations() {
		super();
	}
	
	public Locations(Customers cID, String address) {
		super();
		CID = cID;
		Address = address;
	}
	
	public Customers getCID() {
		return CID;
	}
	public void setCID(Customers cID) {
		CID = cID;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Locations [CID=" + CID + ", Address=" + Address + "]";
	}
	
	
}
