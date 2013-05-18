package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TeamItemEquiped {
	
	private Integer id;
	private TeamItem teamItem;
	private boolean equiped;
	
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	public TeamItem getTeamItem() {
		return teamItem;
	}
	public void setTeamItem(TeamItem teamItem) {
		this.teamItem = teamItem;
	}
	
	public boolean isEquiped() {
		return equiped;
	}
	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
}
