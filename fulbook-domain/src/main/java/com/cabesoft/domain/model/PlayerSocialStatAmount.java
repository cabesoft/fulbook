package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.model.utils.PlayerSocialStatPK;
@Entity
@IdClass(PlayerSocialStatPK.class)

public class PlayerSocialStatAmount {
	@Id
	private Player player;
	@Id
	private SocialStat socialStat;
	
	private Integer amount;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public SocialStat getSocialStat() {
		return socialStat;
	}
	public void setSocialStat(SocialStat socialStat) {
		this.socialStat = socialStat;
	}
	
	
}