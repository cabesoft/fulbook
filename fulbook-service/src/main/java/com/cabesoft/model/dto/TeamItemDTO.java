package com.cabesoft.model.dto;

import java.util.Set;

import com.cabesoft.domain.enums.TeamSlot;

public class TeamItemDTO {
	private TeamSlot slot;
	private  Set<TeamStatAmountDTO> stats;
	
	public TeamSlot getSlot() {
		return slot;
	}
	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}
	public Set<TeamStatAmountDTO> getStats() {
		return stats;
	}
	public void setStats(Set<TeamStatAmountDTO> stats) {
		this.stats = stats;
	}

}
