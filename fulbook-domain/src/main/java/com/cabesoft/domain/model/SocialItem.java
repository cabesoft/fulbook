package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.SocialSlot;
@Entity
public class SocialItem extends Item{
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private List<ItemSocialStatAmount> socialStats;
	
	@Enumerated(EnumType.STRING) 
	private SocialSlot slot;

	public List<ItemSocialStatAmount> getSocialStats() {
		return socialStats;
	}

	public void setSocialStats(List<ItemSocialStatAmount> socialStats) {
		this.socialStats = socialStats;
	}

	public SocialSlot getSlot() {
		return slot;
	}

	public void setSlot(SocialSlot slot) {
		this.slot = slot;
	}

}
