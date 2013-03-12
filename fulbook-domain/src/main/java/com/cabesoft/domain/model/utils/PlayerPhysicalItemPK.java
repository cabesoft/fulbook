package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.domain.model.Player;

public class PlayerPhysicalItemPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Player player;
	@ManyToOne
	private PhysicalItem physicalItem;

	public PlayerPhysicalItemPK() {
		
	}
	
	public PlayerPhysicalItemPK(Player player, PhysicalItem item) {
		this.player = player;
		this.physicalItem = item;
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public PhysicalItem getPhysicalItem() {
		return physicalItem;
	}

	public void setPhysicalItem(PhysicalItem physicalItem) {
		this.physicalItem = physicalItem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((physicalItem == null) ? 0 : physicalItem.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerPhysicalItemPK other = (PlayerPhysicalItemPK) obj;
		if (physicalItem == null) {
			if (other.physicalItem != null)
				return false;
		} else if (!physicalItem.equals(other.physicalItem))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		return true;
	}

	
	
	
	
}
