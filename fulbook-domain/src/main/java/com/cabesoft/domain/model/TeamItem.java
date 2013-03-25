package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.cabesoft.domain.enums.TeamSlot;
@Entity
public class TeamItem extends Item{

	
	private TeamSlot slot;


	@Enumerated(EnumType.STRING) 
	public TeamSlot getSlot() {
		return slot;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}

}
