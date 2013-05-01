package com.cabesoft.model.dto;


public class SocialItemEquipedDTO {
	private Integer id;
	private SocialItemDTO item;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SocialItemDTO getItem() {
		return item;
	}
	public void setItem(SocialItemDTO item) {
		this.item = item;
	}
	public boolean isEquiped() {
		return equiped;
	}
	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
	private boolean equiped;
}
