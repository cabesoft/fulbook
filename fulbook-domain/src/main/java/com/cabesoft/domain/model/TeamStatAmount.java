package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cabesoft.domain.enums.TeamStat;

@Entity
@Table(name = "team_stat_amount")
public class TeamStatAmount {

	private Integer id;

	private TeamStat stat;

	private Integer amount;

	public TeamStatAmount(TeamStat stat, Integer amount) {
		this.stat = stat;
		this.amount = amount;
	}

	@Enumerated(EnumType.STRING)
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

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "oid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
