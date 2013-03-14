package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.model.PhysicalItem;

public class ItemPhysicalStatPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private PhysicalItem item;
	
	private PhysicalStat physicalStat;
	
	public ItemPhysicalStatPK(){
		
	}

	public PhysicalStat getPhysicalStat() {
		return physicalStat;
	}
	public void setPhysicalStat(PhysicalStat physicalStat) {
		this.physicalStat = physicalStat;
	}

	public PhysicalItem getItem() {
		return item;
	}

	public void setItem(PhysicalItem item) {
		this.item = item;
	}
}
