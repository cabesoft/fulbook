package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PhysicalItemEquiped {
	
	private Integer id;
	private PhysicalItem physicalItem;
	private boolean equiped;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	public PhysicalItem getPhysicalItem() {
		return physicalItem;
	}
	public void setPhysicalItem(PhysicalItem physicalItem) {
		this.physicalItem = physicalItem;
	}
	
	public boolean isEquiped() {
		return equiped;
	}
	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
