package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="social_event")
public class SocialEvent extends Event{
	
	private Set<SocialStatAmount> socialStats;
	private Set<SocialItem> itemsRequired;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<SocialStatAmount> getSocialStats() {
		return socialStats;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<SocialItem> getItemsRequired() {
		return itemsRequired;
	}

	public void setSocialStats(Set<SocialStatAmount> socialStats) {
		this.socialStats = socialStats;
	}
	public void setItemsRequired(Set<SocialItem> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

}
