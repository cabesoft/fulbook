package com.cabesoft.model.dto;

import com.cabesoft.domain.model.TeamStat;

public class TeamStatAmountDTO {
	private Integer id;
	private TeamStat stat;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TeamStat getStat() {
		return stat;
	}
	public void setStat(TeamStat stat) {
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
