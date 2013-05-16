package com.cabesoft.model.dto;

import java.util.HashMap;
import java.util.Map;

import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PhysicalStat;

public class PhysicalItemDTO extends ItemDTO {
	private PhysicalSlot slot;
	private Map<PhysicalStat, Integer> stats = new HashMap<PhysicalStat, Integer>();

	public PhysicalItemDTO() {
	}

	public PhysicalSlot getSlot() {
		return slot;
	}

	public void setSlot(PhysicalSlot slot) {
		this.slot = slot;
	}

	public Map<PhysicalStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<PhysicalStat, Integer> stats) {
		this.stats = stats;
	}

}
