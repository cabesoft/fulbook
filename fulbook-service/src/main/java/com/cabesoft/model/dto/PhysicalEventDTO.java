package com.cabesoft.model.dto;

import java.util.Set;

public class PhysicalEventDTO extends EventDTO {
	
	private Integer expiriencie;
	private Integer energy;
	private Set<PhysicalItemDTO> itemsRequired;
	
	public Integer getExpiriencie() {
		return expiriencie;
	}
	public Integer getEnergy() {
		return energy;
	}
	public Set<PhysicalItemDTO> getItemsRequired() {
		return itemsRequired;
	}
	public void setExpiriencie(Integer expiriencie) {
		this.expiriencie = expiriencie;
	}
	public void setEnergy(Integer energy) {
		this.energy = energy;
	}
	public void setItemsRequired(Set<PhysicalItemDTO> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}
	
	
}
