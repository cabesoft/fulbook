package com.cabesoft.model.dto;

import java.util.HashMap;
import java.util.Map;

import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.SocialStat;

public class SocialItemDTO extends ItemDTO {
	private SocialSlot slot;
	private Map<SocialStat, Integer> stats = new HashMap<SocialStat, Integer>();

	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}

	public Map<SocialStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<SocialStat, Integer> stats) {
		this.stats = stats;
	}

}
