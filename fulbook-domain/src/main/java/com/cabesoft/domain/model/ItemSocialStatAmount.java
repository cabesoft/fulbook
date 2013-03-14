package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.domain.model.utils.ItemSocialStatPK;
@Entity
@IdClass(ItemSocialStatPK.class)
public class ItemSocialStatAmount {
	@Id
	private SocialItem item;
	@Id
	private SocialStat socialStat;
	
	private Integer amount;

	public SocialItem getItem() {
		return item;
	}
	public void setItem(SocialItem item) {
		this.item = item;
	}
	public SocialStat getSocialStat() {
		return socialStat;
	}
	public void setSocialStat(SocialStat socialStat) {
		this.socialStat = socialStat;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	

}
