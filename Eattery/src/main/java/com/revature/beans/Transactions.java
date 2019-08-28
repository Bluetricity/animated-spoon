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
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bob")
	@SequenceGenerator(name="bob", sequenceName="transaction_seq", allocationSize=1)
	Integer TID;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="CID")
	Customers CID;
	String PAYMENT_TYPE;
}
