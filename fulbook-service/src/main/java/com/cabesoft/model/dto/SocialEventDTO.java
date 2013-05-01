package com.cabesoft.model.dto;

import java.util.Set;


public class SocialEventDTO extends EventDTO{
	
	private Set<SocialStatAmountDTO> socialStats;
	private Set<SocialItemDTO> itemsRequired;
	
	public Set<SocialStatAmountDTO> getSocialStats() {
		return socialStats;
	}
	public Set<SocialItemDTO> getItemsRequired() {
		return itemsRequired;
	}
	public void setSocialStats(Set<SocialStatAmountDTO> socialStats) {
		this.socialStats = socialStats;
	}
	public void setItemsRequired(Set<SocialItemDTO> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}
}
