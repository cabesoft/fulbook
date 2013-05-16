package com.cabesoft.domain.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;

import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PhysicalStat;

@Entity
@Table(name = "physical_item")
public class PhysicalItem extends Item {

	private PhysicalSlot slot;
	private Map<PhysicalStat, Integer> stats;

	public PhysicalItem() {
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "physical_slot", nullable = false)
	public PhysicalSlot getSlot() {
		return slot;
	}

	public void setSlot(PhysicalSlot slot) {
		this.slot = slot;
	}

	@CollectionOfElements
	@MapKeyEnumerated(EnumType.STRING)
	public Map<PhysicalStat, Integer> getStats() {
		return stats;
	}

	public void setStats(Map<PhysicalStat, Integer> stats) {
		this.stats = stats;
	}

}
