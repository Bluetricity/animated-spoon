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
	String mealname;
	Double price;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(Integer mID, String mealname, Double price) {
		super();
		MID = mID;
		this.mealname = mealname;
		this.price = price;
	}
	
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
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

	@Override
	public String toString() {
		return "Menu [MID=" + MID + ", mealname=" + mealname + ", price=" + price + "]";
	}
	
	
}
