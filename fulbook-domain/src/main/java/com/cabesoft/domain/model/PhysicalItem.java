package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cabesoft.domain.enums.PhysicalSlot;

@Entity
@Table(name = "physical_item")
public class PhysicalItem extends Item {

	private PhysicalSlot slot;
	private Set<PhysicalStatAmount> stats;

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<PhysicalStatAmount> getStats() {
		return stats;
	}

	public void setStats(Set<PhysicalStatAmount> stats) {
		this.stats = stats;
	}

}
