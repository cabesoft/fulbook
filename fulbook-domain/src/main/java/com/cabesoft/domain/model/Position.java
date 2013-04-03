package com.cabesoft.domain.model;

import javax.persistence.Column;
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
	@Column(name = "played_games", nullable = false)
	public Integer getPlayedGames() {
		return playedGames;
	}
	public void setPlayedGames(Integer playedGames) {
		this.playedGames = playedGames;
	}
	@Column(name = "won_games", nullable = false)
	public Integer getWonGames() {
		return wonGames;
	}
	public void setWonGames(Integer wonGames) {
		this.wonGames = wonGames;
	}
	@Column(name = "draw_games", nullable = false)
	public Integer getDrawGames() {
		return drawGames;
	}
	public void setDrawGames(Integer drawGames) {
		this.drawGames = drawGames;
	}	
	@Column(name = "lost_games", nullable = false)
	public Integer getLostGames() {
		return lostGames;
	}
	public void setLostGames(Integer lostGames) {
		this.lostGames = lostGames;
	}
	@Column(name = "goals_in_favor", nullable = false)
	public Integer getGoalsInFavor() {
		return goalsInFavor;
	}
	public void setGoalsInFavor(Integer goalsInFavor) {
		this.goalsInFavor = goalsInFavor;
	}
	@Column(name = "goals_against", nullable = false)
	public Integer getGoalsAgainst() {
		return goalsAgainst;
	}
	public void setGoalsAgainst(Integer goalsAgainst) {
		this.goalsAgainst = goalsAgainst;
	}
	@Column(name = "points", nullable = false)
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	

}
