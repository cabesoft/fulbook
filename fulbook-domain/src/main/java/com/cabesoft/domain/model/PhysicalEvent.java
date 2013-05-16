package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phsysical_event")
public class PhysicalEvent extends Event {

	private Integer expiriencie;
	private Integer energy;
	private Set<PhysicalItem> itemsRequired;
	private Integer fakeMoney;

	public PhysicalEvent() {
	}

	@Column(name = "expirience", nullable = false)
	public Integer getExpiriencie() {
		return expiriencie;
	}

	@Column(name = "energy", nullable = false)
	public Integer getEnergy() {
		return energy;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<PhysicalItem> getItemsRequired() {
		return itemsRequired;
	}

	public void setExpiriencie(Integer expiriencie) {
		this.expiriencie = expiriencie;
	}

	public void setEnergy(Integer energy) {
		this.energy = energy;
	}

	public void setItemsRequired(Set<PhysicalItem> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

	public Integer getFakeMoney() {
		return fakeMoney;
	}

	public void setFakeMoney(Integer fakeMoney) {
		this.fakeMoney = fakeMoney;
	}

}
