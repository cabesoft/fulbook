package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.cabesoft.domain.utils.pks.GamePK;

@Entity
public class Game {
	
    @EmbeddedId
	private GamePK gamePK;
    private Integer localGoals;
    private Integer visitorsGoals;
    
    
	public GamePK getGamePK() {
		return gamePK;
	}
	public void setGamePK(GamePK gamePK) {
		this.gamePK = gamePK;
	}
	@Column(name = "local_goals", nullable = false)
	public Integer getLocalGoals() {
		return localGoals;
	}
	public void setLocalGoals(Integer localGoals) {
		this.localGoals = localGoals;
	}
	@Column(name = "visitor_goals", nullable = false)
	public Integer getVisitorsGoals() {
		return visitorsGoals;
	}
	public void setVisitorsGoals(Integer visitorsGoals) {
		this.visitorsGoals = visitorsGoals;
	}

}
