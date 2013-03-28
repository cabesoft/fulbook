package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.TeamSlot;
@Entity
public class TeamItem extends Item{

	
	private TeamSlot slot;
	private  Set<TeamStatAmount> stats;


	@Enumerated(EnumType.STRING) 
	public TeamSlot getSlot() {
		return slot;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}
	
   @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<TeamStatAmount> getStats() {
		return stats;
	}

	public void setStats(Set<TeamStatAmount> stats) {
		this.stats = stats;
	}

}
