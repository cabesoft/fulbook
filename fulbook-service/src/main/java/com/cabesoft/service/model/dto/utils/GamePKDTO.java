package com.cabesoft.service.model.dto.utils;

import com.cabesoft.model.dto.LeagueDTO;
import com.cabesoft.model.dto.TeamDTO;

public class GamePKDTO {
	private LeagueDTO league;
	private TeamDTO local;
	
	private TeamDTO visitors;
	
	
	public LeagueDTO getLeague() {
		return league;
	}
	public void setLeague(LeagueDTO league) {
		this.league = league;
	}
	public TeamDTO getLocal() {
		return local;
	}
	public void setLocal(TeamDTO local) {
		this.local = local;
	}
	public TeamDTO getVisitors() {
		return visitors;
	}
	public void setVisitors(TeamDTO visitors) {
		this.visitors = visitors;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	private Integer date;
}
