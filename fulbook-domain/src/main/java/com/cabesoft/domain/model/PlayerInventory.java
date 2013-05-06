package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;

@Embeddable
public class PlayerInventory {
	private Set<PhysicalItem> physicalItems;
	private Set<SocialItem> socialItems;

	@OneToMany
	public Set<PhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	@OneToMany
	public Set<SocialItem> getSocialItems() {
		return socialItems;
	}

	public void setPhysicalItems(Set<PhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public void setSocialItems(Set<SocialItem> socialItems) {
		this.socialItems = socialItems;
	}

}
