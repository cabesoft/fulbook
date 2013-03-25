package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TeamStat extends Stat {

	private Set<TeamItemStat> stats;

	@OneToMany
	@JoinColumn(name="stat_id")
	public Set<TeamItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<TeamItemStat> stats) {
		this.stats = stats;
	}
}
