package com.cabesoft.model.dto;


public class PhysicalItemEquipedDTO {
	private Integer id;
	private PhysicalItemDTO item;
	private boolean equiped;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PhysicalItemDTO getItem() {
		return item;
	}

	public void setItem(PhysicalItemDTO item) {
		this.item = item;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}

}
