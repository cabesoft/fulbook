package com.cabesoft.model.dto;

import java.util.HashMap;
import java.util.Map;

import com.cabesoft.domain.enums.TeamSlot;
import com.cabesoft.domain.enums.TeamStat;

public class TeamItemDTO {
	private TeamSlot slot;
	private Map<TeamStat, Integer> stats = new HashMap<TeamStat, Integer>();

	public TeamSlot getSlot() {
		return slot;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}

	public Map<TeamStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<TeamStat, Integer> stats) {
		this.stats = stats;
	}

}
