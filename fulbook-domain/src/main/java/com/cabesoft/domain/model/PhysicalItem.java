package com.cabesoft.domain.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.PhysicalSlot;
@Entity
public class PhysicalItem extends Item{

	
	private PhysicalSlot slot;
	private  Set<PhysicalItemStat> stats;

	@Enumerated(EnumType.STRING) 
	public PhysicalSlot getSlot() {
		return slot;
	}

	public void setSlot(PhysicalSlot slot) {
		this.slot = slot;
	}

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="item_id")
	public Set<PhysicalItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<PhysicalItemStat> stats) {
		this.stats = stats;
	}

	
	
}
