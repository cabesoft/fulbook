package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cabesoft.domain.enums.SocialSlot;

@Entity
@Table(name = "social_item")
public class SocialItem extends Item {

	private SocialSlot slot;

	private Set<SocialStatAmount> stats ;
	@Enumerated(EnumType.STRING)
	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}
	@OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<SocialStatAmount> getStats() {
		return stats;
	}

	public void setStats(Set<SocialStatAmount> stats) {
		this.stats = stats;
	}



}
