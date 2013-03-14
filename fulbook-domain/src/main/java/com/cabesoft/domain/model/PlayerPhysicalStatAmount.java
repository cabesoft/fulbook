package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.model.utils.PlayerPhysicalStatPK;
@Entity
@IdClass(PlayerPhysicalStatPK.class)

public class PlayerPhysicalStatAmount {
	@Id
	private Player player;
	@Id
	private PhysicalStat physicalStat;
	
	private Integer amount;
	
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}