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
public class Menu {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="menu_seq", allocationSize=1)
	Integer MID;
	@Column(name="MTID")
	Menu_Type MTID;
	@Column(name="MEALNAME")
	String mealname;
	@Column(name="PRICE")
	Double price;
	@Column(name="DESCRIPTION")
	String desc;
	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(Integer mID, String mealname, Double price, String desc) {
		super();
		MID = mID;
		this.mealname = mealname;
		this.price = price;
		this.desc = desc;
	}
	
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
	}
	public Menu_Type getMTID() {
		return MTID;
	}
	public void setMTID(Menu_Type mTID) {
		MTID = mTID;
	}
	public String getMealname() {
		return mealname;
	}
	public void setMealname(String mealname) {
		this.mealname = mealname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MID == null) ? 0 : MID.hashCode());
		result = prime * result + ((MTID == null) ? 0 : MTID.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((mealname == null) ? 0 : mealname.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (MID == null) {
			if (other.MID != null)
				return false;
		} else if (!MID.equals(other.MID))
			return false;
		if (MTID == null) {
			if (other.MTID != null)
				return false;
		} else if (!MTID.equals(other.MTID))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (mealname == null) {
			if (other.mealname != null)
				return false;
		} else if (!mealname.equals(other.mealname))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Menu [MID=" + MID + ", MTID=" + MTID + ", mealname=" + mealname + ", price=" + price + ", desc=" + desc
				+ "]";
	}	
	
}
