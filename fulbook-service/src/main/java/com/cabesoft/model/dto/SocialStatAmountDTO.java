package com.cabesoft.model.dto;


public class SocialStatAmountDTO {
	private Integer id;
	private SocialStatDTO stat;

	public SocialStatDTO getStat() {
		return stat;
	}

	public void setStat(SocialStatDTO stat) {
		this.stat = stat;
	}

	private Integer amount;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
