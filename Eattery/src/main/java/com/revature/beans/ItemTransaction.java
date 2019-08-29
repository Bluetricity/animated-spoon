package com.revature.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class ItemTransaction {
	@Id
	Integer TID;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CID")
	Customers CID;
	String PAYMENT_TYPE;
	
	public ItemTransaction() {
		super();
	}

	public ItemTransaction(Integer tID, Customers cID, String pAYMENT_TYPE) {
		super();
		TID = tID;
		CID = cID;
		PAYMENT_TYPE = pAYMENT_TYPE;
	}
	
	public Integer getTID() {
		return TID;
	}
	public void setTID(Integer tID) {
		TID = tID;
	}
	public Customers getCID() {
		return CID;
	}
	public void setCID(Customers cID) {
		CID = cID;
	}
	public String getPAYMENT_TYPE() {
		return PAYMENT_TYPE;
	}
	public void setPAYMENT_TYPE(String pAYMENT_TYPE) {
		PAYMENT_TYPE = pAYMENT_TYPE;
	}
	
	@Override
	public String toString() {
		return "ItemTransaction [TID=" + TID + ", CID=" + CID + ", PAYMENT_TYPE=" + PAYMENT_TYPE + "]";
	}
	
}
