package com.cabesoft.model.dto;

public class MoneyDTO {
	private Integer fakeMoney;
	private Integer tokenMoney;

	public MoneyDTO() {

	}

	public MoneyDTO(Integer fakeMoney, Integer tokenMoney) {
		this.fakeMoney = fakeMoney;
		this.tokenMoney = tokenMoney;
	}

	public Integer getFakeMoney() {
		return fakeMoney;
	}

	public Integer getTokenMoney() {
		return tokenMoney;
	}

	public void setFakeMoney(Integer fakeMoney) {
		this.fakeMoney = fakeMoney;
	}

	public void setTokenMoney(Integer tokenMoney) {
		this.tokenMoney = tokenMoney;
	}
}
