package com.cabesoft.domain.model;

import java.util.List;

import com.cabesoft.domain.enums.TeamSlot;

public class TeamItem extends Item{
	
	List<TeamStatAmount> teamStats;
	
	private TeamSlot slot;

	public List<TeamStatAmount> getTeamStats() {
		return teamStats;
	}

	public TeamSlot getSlot() {
		return slot;
	}

	public void setTeamStats(List<TeamStatAmount> teamStats) {
		this.teamStats = teamStats;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}

}
