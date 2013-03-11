package com.cabesoft.domain.model;

import com.cabesoft.domain.enums.SocialStat;

public class SocialStatAmount {
	private SocialStat socialAmount;
	private Integer amount;
	
	public SocialStat getSocialAmount() {
		return socialAmount;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setSocialAmount(SocialStat socialAmount) {
		this.socialAmount = socialAmount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
