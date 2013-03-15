package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;


import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStat;

public class PlayerSocialStatPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Player player;
	@ManyToOne
	private SocialStat socialStat;
	
	public PlayerSocialStatPK(){
		
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public com.cabesoft.domain.model.SocialStat getSocialStat() {
		return socialStat;
	}
	public void setSocialStat(SocialStat socialStat) {
		this.socialStat = socialStat;
	}
	
}
