package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;


import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.domain.model.Player;

public class PlayerSocialStatPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Player player;
	private SocialStat socialStat;
	
	public PlayerSocialStatPK(){
		
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public SocialStat getSocialStat() {
		return socialStat;
	}
	public void setSocialStat(SocialStat socialStat) {
		this.socialStat = socialStat;
	}
	
}
