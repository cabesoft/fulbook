package com.cabesoft.model.dto;

import java.util.Set;

import com.cabesoft.domain.enums.PhysicalSlot;

public class PhysicalItemDTO  extends ItemDTO{
	private PhysicalSlot slot;
	private Set<PhysicalStatAmountDTO> stats;
	
	public PhysicalSlot getSlot() {
		return slot;
	}
	public void setSlot(PhysicalSlot slot) {
		this.slot = slot;
	}
	public Set<PhysicalStatAmountDTO> getStats() {
		return stats;
	}
	public void setStats(Set<PhysicalStatAmountDTO> stats) {
		this.stats = stats;
	}

}
