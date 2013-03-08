package com.cabesoft.domain.model;

public class PlayerSocialItem {

	
	private SocialItem socialItem;
	
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
