package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Locations {
	
	Integer LID;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	Customers CID;
	String Address;
	
	public Locations() {
		super();
	}
	
	public Locations(Integer lID, Customers cID, String address) {
		super();
		LID = lID;
		CID = cID;
		Address = address;
	}
	
	public Integer getLID() {
		return LID;
	}

	public void setLID(Integer lID) {
		LID = lID;
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
