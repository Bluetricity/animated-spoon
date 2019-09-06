package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "JoinTransactionandItems")
@Table(name = "transactionitems")
@JsonIgnoreProperties(value= {"SID", "MID"})
public class JoinTransactionandItems {

	@EmbeddedId
	JoinStockandMenuID composid; 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="TID", insertable=false, updatable=false)
	private ItemTransaction TID;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MID", insertable=false, updatable=false)
	private Menu MID;
	Double quantity;
	
	public JoinTransactionandItems() {
		super();
	}
	public JoinTransactionandItems(JoinStockandMenuID composid, Double qUANITY) {
		super();
		this.composid = composid;
		quantity = qUANITY;
	}
	public JoinStockandMenuID getComposid() {
		return composid;
	}
	public void setComposid(JoinStockandMenuID composid) {
		this.composid = composid;
	}
	public Double getquantity() {
		return quantity;
	}
	public void setquantity(Double qUANITY) {
		quantity = qUANITY;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		JoinTransactionandItems other = (JoinTransactionandItems) obj;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
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
		return "JoinTransactionandItems [composid=" + composid + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
}
