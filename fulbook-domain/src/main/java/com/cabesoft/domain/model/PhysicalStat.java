package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class PhysicalStat  extends Stat{

	private Set<PhysicalItemStat> stats;

	@OneToMany
	@JoinColumn(name="stat_id")
	public Set<PhysicalItemStat> getStats() {
		return stats;
	}

	public void setStats(Set<PhysicalItemStat> stats) {
		this.stats = stats;
	}

	

}
