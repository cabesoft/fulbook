package com.cabesoft.domain.model;

import java.util.List;

import com.cabesoft.domain.enums.SocialSlot;

public class SocialItem extends Item{
	
	private List<SocialStatAmount> socialStats;
	
	private SocialSlot slot;

	public List<SocialStatAmount> getSocialStats() {
		return socialStats;
	}

	public void setSocialStats(List<SocialStatAmount> socialStats) {
		this.socialStats = socialStats;
	}

	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}

}
