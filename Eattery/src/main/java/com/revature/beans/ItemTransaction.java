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
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="transaction_seq", allocationSize=1)
	Integer TID;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CID")
	Customers CID;
	@Column(name="PAYMENT_TYPE")
	String PAYMENT_TYPE;
	@Column(name="STATUS")
	Integer status;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ItemTransaction [TID=" + TID + ", CID=" + CID + ", PAYMENT_TYPE="
				 + PAYMENT_TYPE + ", STATUS="+status+"]";
	}
	
}
