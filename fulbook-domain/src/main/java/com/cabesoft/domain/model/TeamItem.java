package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.TeamSlot;
@Entity
public class TeamItem extends Item{
	@OneToMany
	List<TeamStatAmount> teamStats;
	
	@Enumerated(EnumType.STRING) 
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
