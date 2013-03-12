package com.cabesoft.domain.model;

import javax.persistence.Embeddable;

@Embeddable
public class Money {
	
	private Integer tokenMoney;
	private Integer money;
	
	public Integer getMoney() {
		return money;
	}

	public Integer getTokenMoney() {
		return tokenMoney;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public void setTokenMoney(Integer tokenMoney) {
		this.tokenMoney = tokenMoney;
	}


}
