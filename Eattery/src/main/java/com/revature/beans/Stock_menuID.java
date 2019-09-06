package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Embeddable
public class Stock_menuID implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="SID")
	private Stock SID;
	
	@ManyToOne
	@JoinColumn(name="MID")
	private Menu MID;

	public Stock_menuID() {
		super();
	}

	public Stock_menuID(Stock sID, Menu mID) {
		super();
		SID = sID;
		MID = mID;
	}

	public Stock getSID() {
		return SID;
	}
	public void setSID(Stock sID) {
		SID = sID;
	}
	public Menu getMID() {
		return MID;
	}
	public void setMID(Menu mID) {
		MID = mID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MID == null) ? 0 : MID.hashCode());
		result = prime * result + ((SID == null) ? 0 : SID.hashCode());
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
		Stock_menuID other = (Stock_menuID) obj;
		if (MID == null) {
			if (other.MID != null)
				return false;
		} else if (!MID.equals(other.MID))
			return false;
		if (SID == null) {
			if (other.SID != null)
				return false;
		} else if (!SID.equals(other.SID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "JoinStockandMenu [SID=" + SID + ", MID=" + MID + "]";
	}
	
	
}
