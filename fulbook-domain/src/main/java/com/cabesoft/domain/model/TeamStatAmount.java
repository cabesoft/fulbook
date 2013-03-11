package com.cabesoft.domain.model;

import com.cabesoft.domain.enums.TeamStat;

public class TeamStatAmount {
	private TeamStat teamStat;
	private Integer amount;
	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public TeamStat getTeamStat() {
		return teamStat;
	}

	public void setTeamStat(TeamStat teamStat) {
		this.teamStat = teamStat;
	}

}
