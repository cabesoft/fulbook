package com.cabesoft.domain.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

import com.cabesoft.domain.enums.TeamSlot;
import com.cabesoft.domain.enums.TeamStat;

@Entity
@Table(name = "team_item")
public class TeamItem extends Item {

	private TeamSlot slot;
	private Map<TeamStat, Integer> stats;

	@Enumerated(EnumType.STRING)
	public TeamSlot getSlot() {
		return slot;
	}

	public void setSlot(TeamSlot slot) {
		this.slot = slot;
	}

	@CollectionOfElements
	@MapKeyEnumerated(EnumType.STRING)
	public Map<TeamStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<TeamStat, Integer> stats) {
		this.stats = stats;
	}

}
