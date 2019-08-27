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
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="stock_seq", allocationSize=1)
	Integer SID;
	@Column(name="INGREDIENT_NAME")
	String ingredient;
	@Column(name="QUANTITY_STORED")
	Double quantity;
	
	public Stock() {
		super();
	}
	
	public Stock(Integer sID, String ingredient, Double quantity) {
		super();
		SID = sID;
		this.ingredient = ingredient;
		this.quantity = quantity;
	}

	public Integer getSID() {
		return SID;
	}
	public void setSID(Integer sID) {
		SID = sID;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Stock [SID=" + SID + ", ingredient=" + ingredient + ", quantity=" + quantity + "]";
	}
	
	
}
