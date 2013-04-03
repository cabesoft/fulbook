package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import javax.persistence.OneToMany;
@Entity
@Table(name="training")
public class Training extends Event {

	private Integer expiriencie;
	private Integer energy;
	private Set<PhysicalItem> itemsRequired;
	

	@Column(name = "expirience", nullable = false)
	public Integer getExpiriencie() {
		return expiriencie;
	}
	@Column(name = "energy", nullable = false)
	public Integer getEnergy() {
		return energy;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
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
	
	
	
}
