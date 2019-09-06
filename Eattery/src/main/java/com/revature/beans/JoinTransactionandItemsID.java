package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class JoinTransactionandItemsID implements Serializable {
	private static final long serialVersionUID = 7403175775238654822L;
	@Column(name="TID")
	private Integer TID;
	@Column(name="MID")
	private Integer MID;

	public JoinTransactionandItemsID() {
		super();
	}

	public Integer getTID() {
		return TID;
	}
	public void setTID(Integer sID) {
		TID = sID;
	}
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MID == null) ? 0 : MID.hashCode());
		result = prime * result + ((TID == null) ? 0 : TID.hashCode());
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
		JoinTransactionandItemsID other = (JoinTransactionandItemsID) obj;
		if (MID == null) {
			if (other.MID != null)
				return false;
		} else if (!MID.equals(other.MID))
			return false;
		if (TID == null) {
			if (other.TID != null)
				return false;
		} else if (!TID.equals(other.TID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinTransactionandMenu [TID=" + TID + ", MID=" + MID + "]";
	}
	
	
}
