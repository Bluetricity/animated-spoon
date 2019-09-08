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
	TransactionsitemsID taiid; 
	Double quanity;
	
	public Transactionitems() {
		super();
	}
	public Transactionitems(TransactionsitemsID taiid, Double qUANITY) {
		super();
		this.taiid = taiid;
		quanity = qUANITY;
	}
	
	public TransactionsitemsID gettaiid() {
		return taiid;
	}
	public void settaiid(TransactionsitemsID taiid) {
		this.taiid = taiid;
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
		result = prime * result + ((taiid == null) ? 0 : taiid.hashCode());
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
		if (taiid == null) {
			if (other.taiid != null)
				return false;
		} else if (!taiid.equals(other.taiid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "JoinTransactionandItems [taiid=" + taiid + ", quanity=" + quanity + "]";
	}
	
	
	
	
	
	
}
