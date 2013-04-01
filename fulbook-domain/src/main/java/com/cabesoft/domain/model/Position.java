package com.cabesoft.domain.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cabesoft.domain.utils.pks.PositionsTablePK;

@Entity
@Table(name="positions_table")
public class Position {
	@EmbeddedId 
    private PositionsTablePK primaryKey;
	
	private Integer playedGames;
	private Integer wonGames;
	private Integer drawGames;
	private Integer lostGames;
	private Integer goalsInFavor;
	private Integer goalsAgainst;
	private Integer points;
	  
	public PositionsTablePK getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(PositionsTablePK primaryKey) {
		this.primaryKey = primaryKey;
	}
	public Integer getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(Integer playedGames) {
		this.playedGames = playedGames;
	}
	public Integer getWonGames() {
		return wonGames;
	}
	public void setWonGames(Integer wonGames) {
		this.wonGames = wonGames;
	}
	public Integer getDrawGames() {
		return drawGames;
	}
	public void setDrawGames(Integer drawGames) {
		this.drawGames = drawGames;
	}
	public Integer getLostGames() {
		return lostGames;
	}
	public void setLostGames(Integer lostGames) {
		this.lostGames = lostGames;
	}
	public Integer getGoalsInFavor() {
		return goalsInFavor;
	}
	public void setGoalsInFavor(Integer goalsInFavor) {
		this.goalsInFavor = goalsInFavor;
	}
	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}
	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	

}
