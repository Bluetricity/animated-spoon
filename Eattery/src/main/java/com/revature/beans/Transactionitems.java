package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Transactionitems")
public class Transactionitems {

	@EmbeddedId
	TransactionsitemsID composid; 
	Double quanity;
	
	public Transactionitems() {
		super();
	}
	public Transactionitems(TransactionsitemsID composid, Double qUANITY) {
		super();
		this.composid = composid;
		quanity = qUANITY;
	}
	
	public TransactionsitemsID getComposid() {
		return composid;
	}
	public void setComposid(TransactionsitemsID composid) {
		this.composid = composid;
	}
	public Double getquanity() {
		return quanity;
	}
	public void setquanity(Double qUANITY) {
		quanity = qUANITY;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quanity == null) ? 0 : quanity.hashCode());
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
		Transactionitems other = (Transactionitems) obj;
		if (quanity == null) {
			if (other.quanity != null)
				return false;
		} else if (!quanity.equals(other.quanity))
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
		return "JoinTransactionandItems [composid=" + composid + ", quanity=" + quanity + "]";
	}
	
	
	
	
	
	
}
