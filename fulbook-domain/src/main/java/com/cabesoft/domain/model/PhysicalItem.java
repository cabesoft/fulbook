package com.cabesoft.domain.model;

import java.util.List;

import com.cabesoft.domain.enums.PhysicalSlot;

public class PhysicalItem extends Item{

	private List<PhysicalStatAmount> physicalStats;
	
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
