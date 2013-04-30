package com.cabesoft.model.dto;

import java.util.Set;

import com.cabesoft.domain.enums.SocialSlot;

public class SocialItemDTO extends ItemDTO{
	private SocialSlot slot;
	private  Set<SocialStatAmountDTO> stats;
	
	public SocialSlot getSlot() {
		return slot;
	}
	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}
	public Set<SocialStatAmountDTO> getStats() {
		return stats;
	}
	public void setStats(Set<SocialStatAmountDTO> stats) {
		this.stats = stats;
	}
}
