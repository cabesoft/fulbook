package com.cabesoft.model.dto;


public class PhysicalStatAmountDTO {
	private Integer id;

	private PhysicalStatDTO stat;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhysicalStatDTO getStat() {
		return stat;
	}

	public void setStat(PhysicalStatDTO stat) {
		this.stat = stat;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	private Integer amount;
}
