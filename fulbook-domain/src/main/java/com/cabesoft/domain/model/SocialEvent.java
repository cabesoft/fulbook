package com.cabesoft.domain.model;

import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

import com.cabesoft.domain.enums.SocialStat;

@Entity
@Table(name = "social_event")
public class SocialEvent extends Event {

	private Map<SocialStat, Integer> socialStats;
	private Set<SocialItem> itemsRequired;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<SocialItem> getItemsRequired() {
		return itemsRequired;
	}

	public void setItemsRequired(Set<SocialItem> itemsRequired) {
		this.itemsRequired = itemsRequired;
	}

	@CollectionOfElements
	@MapKeyEnumerated(EnumType.STRING)
	public Map<SocialStat, Integer> getSocialStats() {
		return socialStats;
	}

	public void setSocialStats(Map<SocialStat, Integer> socialStats) {
		this.socialStats = socialStats;
	}

}
