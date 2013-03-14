package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.model.utils.PlayerSocialItemPK;

@Entity
@IdClass(PlayerSocialItemPK.class)
public class PlayerSocialItem {

	@Id
	private SocialItem socialItem;
	@Id
	private Player player;
	
	private Boolean equiped;
	
	
	public SocialItem getSocialItem() {
		return socialItem;
	}

	public Player getPlayer() {
		return player;
	}

	public Boolean getEquiped() {
		return equiped;
	}

	public void setSocialItem(SocialItem socialItem) {
		this.socialItem = socialItem;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setEquiped(Boolean equiped) {
		this.equiped = equiped;
	}
}
