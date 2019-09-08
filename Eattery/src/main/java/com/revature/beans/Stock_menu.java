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
	Stock_menuID samid; 
	Double amount;
	
	public Stock_menu() {
		super();
	}
	
	public Stock_menu(Stock_menuID samid, Double amount) {
		super();
		this.samid = samid;
		amount = amount;
	}

	public Stock_menuID getsamid() {
		return samid;
	}

	public void setsamid(Stock_menuID samid) {
		this.samid = samid;
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
		result = prime * result + ((samid == null) ? 0 : samid.hashCode());
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
		if (samid == null) {
			if (other.samid != null)
				return false;
		} else if (!samid.equals(other.samid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinStockandMenu [samid=" + samid + ", Amount=" + amount + "]";
	}
	
	
}
