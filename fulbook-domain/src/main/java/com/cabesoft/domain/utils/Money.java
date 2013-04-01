package com.cabesoft.domain.utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Money {
	
	private Integer fakeMoney;
	private Integer tokenMoney;
	
	public Money(){
		
	}
	public Money(Integer fakeMoney,Integer tokenMoney ){
		this.fakeMoney=fakeMoney;
		this.tokenMoney=tokenMoney;
	}
	
	@Column(name = "fake_money", nullable = false)
	public Integer getFakeMoney() {
		return fakeMoney;
	}
	public void setFakeMoney(Integer fakeMoney) {
		this.fakeMoney = fakeMoney;
	}
	
	@Column(name = "token_money", nullable = false)
	public Integer getTokenMoney() {
		return tokenMoney;
	}
	public void setTokenMoney(Integer tokenMoney) {
		this.tokenMoney = tokenMoney;
	}
	

	
}
