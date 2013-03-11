package com.cabesoft.domain.model;

import java.util.List;

public class Training extends PlayerAction{

	private List<PhysicalItem> itemsRequired;
	
	private Integer expirience;
	
	private Money money;
	
	public List<PhysicalItem> getItemsRequired() {
		return itemsRequired;
	}

	public void setItemsRequired(List<PhysicalItem> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

	public Integer getExpirience() {
		return expirience;
	}

	public void setExpirience(Integer expirience) {
		this.expirience = expirience;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}


}
