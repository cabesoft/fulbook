package com.cabesoft.domain.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cabesoft.domain.enums.SocialSlot;
@Entity
public class SocialItem extends Item{
	
	
	private SocialSlot slot;

	@Enumerated(EnumType.STRING) 
	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}

}
