package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Menu_Type {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="menu_type_seq", allocationSize=1)
	Integer MTID;
	@Column(name="MENU_NAME")
	String menu_name;
	
	public Menu_Type() {
		super();
	}
	
	public Menu_Type(Integer mTID, String Menu_name) {
		super();
		this.MTID = mTID;
		this.menu_name = Menu_name;
	}
	public Integer getMTID() {
		return MTID;
	}
	public void setMTID(Integer mTID) {
		MTID = mTID;
	}
	public String getMenuName() {
		return menu_name;
	}
	public void setMenuName(String Menu_Name) {
		menu_name = Menu_Name;
	}
	@Override
	public String toString() {
		return "Menu_Name [MTID=" + MTID +", Menu_Name="+menu_name ;
	}
}
