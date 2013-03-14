package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.enums.Position;
import com.cabesoft.domain.model.utils.PlayerPositionPK;
@Entity
@IdClass(PlayerPositionPK.class)
public class PlayerPosition {
	@Id
	private Player player;
	@Id
	private Position position;
	
	private  Boolean active;
	
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
