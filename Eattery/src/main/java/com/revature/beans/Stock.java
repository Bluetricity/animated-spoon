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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SID == null) ? 0 : SID.hashCode());
		result = prime * result + ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Stock other = (Stock) obj;
		if (SID == null) {
			if (other.SID != null)
				return false;
		} else if (!SID.equals(other.SID))
			return false;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [SID=" + SID + ", ingredient=" + ingredient + ", quantity=" + quantity + "]";
	}
	
	
}
