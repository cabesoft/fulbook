package com.cabesoft.fulbook.web.requests.DTO;

import java.util.Set;

import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.SocialStatAmount;

public class CreatePlayerDTO {
	private String name;
	private String face;
	private Set<PhysicalStatAmount> physicalStats;
	private Set<SocialStatAmount> socialStats;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public Set<PhysicalStatAmount> getPhysicalStats() {
		return physicalStats;
	}
	public void setPhysicalStats(Set<PhysicalStatAmount> physicalStats) {
		this.physicalStats = physicalStats;
	}
	public Set<SocialStatAmount> getSocialStats() {
		return socialStats;
	}
	public void setSocialStats(Set<SocialStatAmount> socialStats) {
		this.socialStats = socialStats;
	}
	
}
