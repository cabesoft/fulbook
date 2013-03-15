package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;


import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.Player;

public class PlayerPhysicalStatPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Player player;
	@ManyToOne
	private PhysicalStat physicalStat;
	
	public PlayerPhysicalStatPK(){
		
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public PhysicalStat getPhysicalStat() {
		return physicalStat;
	}
	public void setPhysicalStat(PhysicalStat physicalStat) {
		this.physicalStat = physicalStat;
	}
}
