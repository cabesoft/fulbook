package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TeamItemStat {
	private Integer id;
	
	private TeamItem item;
	private TeamStat stat;
	
	private Integer amount;
	
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="item_id")
	public TeamItem getItem() {
		return item;
	}
	
	@ManyToOne
	@JoinColumn(name="stat_id")
	public TeamStat getStat() {
		return stat;
	}
	public void setItem(TeamItem item) {
		this.item = item;
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
	
}
