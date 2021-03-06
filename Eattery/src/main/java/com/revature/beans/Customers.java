package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.util.Set;

@Entity
@Table
public class Customers {
	@Id
	@Column(name="CID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="customer_seq", allocationSize=1)
	Integer cid;
	String username;
	String password;
	String name;
	String contactinfo;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cid")
	Set<Locations> locations;

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customers(Integer cID, String username, String password, String name, String contactinfo) {
		super();
		cid = cID;
		this.username = username;
		this.password = password;
		this.name = name;
		this.contactinfo = contactinfo;
	}
	
	public Integer getCID() {
		return cid;
	}
	public void setCID(Integer cID) {
		cid = cID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactinfo() {
		return contactinfo;
	}
	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}
	
	@Override
	public String toString() {
		return "Customers [CID=" + cid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", contactinfo=" + contactinfo + "]";
	}
	
}
