package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class SocialStat extends Stat {
	private Set<SocialItemStat> stats;

	@OneToMany
	@JoinColumn(name="stat_id")
	public Set<SocialItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<SocialItemStat> stats) {
		this.stats = stats;
	}


}
