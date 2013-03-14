package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialItem;

public class PlayerSocialItemPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Player player;
	@ManyToOne
	private SocialItem socialItem;

	public PlayerSocialItemPK() {
		
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public SocialItem getSocialItem() {
		return socialItem;
	}

	public void setSocialItem(SocialItem socialItem) {
		this.socialItem = socialItem;
	}
	
	


	
	
	
	
}
