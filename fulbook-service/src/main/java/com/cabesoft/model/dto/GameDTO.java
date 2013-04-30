package com.cabesoft.model.dto;

import com.cabesoft.service.model.dto.utils.GamePKDTO;

public class GameDTO {
	private GamePKDTO gamePK;
	private Integer localGoals;
	private Integer visitorsGoals;
	
	public GamePKDTO getGamePK() {
		return gamePK;
	}
	public void setGamePK(GamePKDTO gamePK) {
		this.gamePK = gamePK;
	}
	public Integer getLocalGoals() {
		return localGoals;
	}
	public void setLocalGoals(Integer localGoals) {
		this.localGoals = localGoals;
	}
	public Integer getVisitorsGoals() {
		return visitorsGoals;
	}
	public void setVisitorsGoals(Integer visitorsGoals) {
		this.visitorsGoals = visitorsGoals;
	}

}
