package com.cabesoft.domain.model;

import com.cabesoft.domain.enums.Position;

public class PlayerPosition {

	private  Boolean active;
	
	private Player player;
	
	private Position position;
	
	private Integer rankingPoints;
	
	private Integer positionPoints;
	
	public Boolean getActive() {
		return active;
	}

	public Player getPlayer() {
		return player;
	}

	public Position getPosition() {
		return position;
	}

	public Integer getRankingPoints() {
		return rankingPoints;
	}

	public Integer getPositionPoints() {
		return positionPoints;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setRankingPoints(Integer rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

	public void setPositionPoints(Integer positionPoints) {
		this.positionPoints = positionPoints;
	}

}
