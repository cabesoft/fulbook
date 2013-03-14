package com.cabesoft.domain.model;

import java.util.List;

public class SocialEvent extends PlayerAction {

	private List<SocialItem> itemsRequired;
	
	private List<ItemSocialStatAmount>  stats;

	public List<SocialItem> getItemsRequired() {
		return itemsRequired;
	}

	public void setItemsRequired(List<SocialItem> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

	public List<ItemSocialStatAmount> getStats() {
		return stats;
	}

	public void setStats(List<ItemSocialStatAmount> stats) {
		this.stats = stats;
	}
}
