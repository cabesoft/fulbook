package com.cabesoft.domain.model.utils;

import javax.persistence.ManyToOne;

import com.cabesoft.domain.enums.Position;
import com.cabesoft.domain.model.Player;

public class PlayerPositionPK {
	@ManyToOne
	private Player player;
	private Position position;
	
	public PlayerPositionPK(){
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
}
