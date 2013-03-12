package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.PhysicalSlot;
@Entity
public class PhysicalItem extends Item{
	@OneToMany
	private List<PhysicalStatAmount> physicalStats;
	
	@Enumerated(EnumType.STRING) 
	private PhysicalSlot slot;

	public PhysicalSlot getSlot() {
		return slot;
	}

	public void setSlot(PhysicalSlot slot) {
		this.slot = slot;
	}

	public List<PhysicalStatAmount> getPhysicalStats() {
		return physicalStats;
	}

	public void setPhysicalStats(List<PhysicalStatAmount> physicalStats) {
		this.physicalStats = physicalStats;
	}
	
	
}
