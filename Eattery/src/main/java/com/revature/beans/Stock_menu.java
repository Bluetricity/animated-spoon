package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_MENU")
public class Stock_menu {
	@EmbeddedId
	Stock_menuID composid; 
	Double amount;
	
	public Stock_menu() {
		super();
	}
	
	public Stock_menu(Stock_menuID composid, Double amount) {
		super();
		this.composid = composid;
		amount = amount;
	}

	public Stock_menuID getComposid() {
		return composid;
	}

	public void setComposid(Stock_menuID composid) {
		this.composid = composid;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((composid == null) ? 0 : composid.hashCode());
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
		Stock_menu other = (Stock_menu) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (composid == null) {
			if (other.composid != null)
				return false;
		} else if (!composid.equals(other.composid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinStockandMenu [composid=" + composid + ", Amount=" + amount + "]";
	}
	
	
}
