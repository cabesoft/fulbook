package com.cabesoft.model.dto;

import java.util.Map;
import java.util.Set;

import com.cabesoft.domain.enums.SocialStat;

public class SocialEventDTO extends EventDTO {

	private Map<SocialStat, Integer> socialStats;
	private Set<SocialItemDTO> itemsRequired;

	public Set<SocialItemDTO> getItemsRequired() {
		return itemsRequired;
	}

	public void setItemsRequired(Set<SocialItemDTO> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

	public Map<SocialStat, Integer> getSocialStats() {
		return socialStats;
	}

	public void setSocialStats(Map<SocialStat, Integer> socialStats) {
		this.socialStats = socialStats;
	}

}
