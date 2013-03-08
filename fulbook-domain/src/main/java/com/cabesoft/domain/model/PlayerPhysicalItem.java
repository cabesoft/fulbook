package com.cabesoft.domain.model;

public class PlayerPhysicalItem  {

	private PhysicalItem physicalItem;
	
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
