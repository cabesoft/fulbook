package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.TeamSlot;
@Entity
public class TeamItem extends Item{

	
	private TeamSlot slot;
	private  Set<TeamItemStat> stats;


	@Enumerated(EnumType.STRING) 
	public TeamSlot getSlot() {
		return slot;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}
	
   @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="item_id")
	public Set<TeamItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<TeamItemStat> stats) {
		this.stats = stats;
	}

}
