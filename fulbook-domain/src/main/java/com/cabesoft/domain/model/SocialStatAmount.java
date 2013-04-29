package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "social_stat_amount")
public class SocialStatAmount {

	private Integer id;

	private SocialStat stat;

	private Integer amount;

	public SocialStatAmount(SocialStat stat, Integer amount) {
		this.stat = stat;
		this.amount = amount;

	}

	public SocialStatAmount() {
	}

	@ManyToOne
	public SocialStat getStat() {
		return stat;
	}

	public void setStat(SocialStat stat) {
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
