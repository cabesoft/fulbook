package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SocialItemEquiped {
	
	private Integer id;
	private SocialItem socialItem;
	private boolean equiped;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	public SocialItem getSocialItem() {
		return socialItem;
	}
	public void setSocialItem(SocialItem socialItem) {
		this.socialItem = socialItem;
	}
	
	public boolean isEquiped() {
		return equiped;
	}
	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
