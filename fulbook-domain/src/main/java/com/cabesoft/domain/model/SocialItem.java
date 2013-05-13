package com.cabesoft.domain.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.SocialStat;

@Entity
@Table(name = "social_item")
public class SocialItem extends Item {

	private SocialSlot slot;

	private Map<SocialStat, Integer> stats = new HashMap<SocialStat, Integer>();

	@Enumerated(EnumType.STRING)
	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}

	@ElementCollection
	@MapKeyEnumerated(EnumType.STRING)
	public Map<SocialStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<SocialStat, Integer> stats) {
		this.stats = stats;
	}

}
