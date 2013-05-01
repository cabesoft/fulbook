package com.cabesoft.service.impl.utils;

import com.cabesoft.model.dto.LeagueDTO;

public class LeaguePositionResponse {
	private LeagueDTO league;
	private int position;

	public LeaguePositionResponse(LeagueDTO league) {
		this.league = league;
		this.position = league.getTeams().size();
	}

	public LeagueDTO getLeague() {
		return league;
	}

	public int getPosition() {
		return position;
	}

	public void setLeague(LeagueDTO league) {
		this.league = league;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
