package com.cabesoft.domain.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Money {
	
	private Integer fakeMoney;
	private Integer tokenMoney;
	
    @Column(name="fake_money")
	public Integer getFakeMoney() {
		return fakeMoney;
	}
	public void setFakeMoney(Integer fakeMoney) {
		this.fakeMoney = fakeMoney;
	}
	
	@Column(name="token_money")
	public Integer getTokenMoney() {
		return tokenMoney;
	}
	public void setTokenMoney(Integer tokenMoney) {
		this.tokenMoney = tokenMoney;
	}
	

	
}
