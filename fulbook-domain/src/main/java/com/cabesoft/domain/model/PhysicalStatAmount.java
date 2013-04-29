package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "physical_stat_amount")
public class PhysicalStatAmount {

	private Integer id;

	private PhysicalStat stat;

	private Integer amount;

	public PhysicalStatAmount(PhysicalStat physicalStat, Integer amount) {
		this.stat = physicalStat;
		this.amount = amount;
	}

	public PhysicalStatAmount() {
	}

	@ManyToOne
	public PhysicalStat getStat() {
		return stat;
	}

	public void setStat(PhysicalStat stat) {
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
