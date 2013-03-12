package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.model.utils.PlayerPhysicalItemPK;

@Entity
@IdClass(PlayerPhysicalItemPK.class)
public class PlayerPhysicalItem  {
	@Id
	private PhysicalItem physicalItem;
	@Id
	private Player player;
	
	private Boolean equiped;
	
	
	public PhysicalItem getPhysicalItem() {
		return physicalItem;
	}

	public Player getPlayer() {
		return player;
	}

	public Boolean getEquiped() {
		return equiped;
	}

	public void setPhysicalItem(PhysicalItem physicalItem) {
		this.physicalItem = physicalItem;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEquiped(Boolean equiped) {
		this.equiped = equiped;
	}

	
}
