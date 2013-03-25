package com.cabesoft.domain.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.SocialSlot;
@Entity
public class SocialItem extends Item{
	
	
	private SocialSlot slot;
	private  Set<SocialItemStat> stats;

	@Enumerated(EnumType.STRING) 
	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="item_id")
	public Set<SocialItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<SocialItemStat> stats) {
		this.stats = stats;
	}

}
