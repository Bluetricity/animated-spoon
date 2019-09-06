package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK_MENU")
public class JoinStockandMenu {
	@EmbeddedId
	JoinStockandMenuID composid; 
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TID", insertable=false, updatable=false)
	private ItemTransaction TID;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MID", insertable=false, updatable=false)
	private Menu MID;
	
	Double Amount;
	
	public JoinStockandMenu() {
		super();
	}
	
	public JoinStockandMenu(JoinStockandMenuID composid, Double amount) {
		super();
		this.composid = composid;
		Amount = amount;
	}

	public ItemTransaction getTID() {
		return TID;
	}
	public void setTID(ItemTransaction tID) {
		TID = tID;
	}
	public Menu getMID() {
		return MID;
	}
	public void setMID(Menu mID) {
		MID = mID;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Amount == null) ? 0 : Amount.hashCode());
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
		JoinStockandMenu other = (JoinStockandMenu) obj;
		if (Amount == null) {
			if (other.Amount != null)
				return false;
		} else if (!Amount.equals(other.Amount))
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
		return "JoinStockandMenu [composid=" + composid + ", Amount=" + Amount + "]";
	}
	
	
}
