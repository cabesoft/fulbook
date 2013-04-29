package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "physical_item_equiped")
public class PhysicalItemEquiped {

	private Integer id;

	private PhysicalItem item;

	private boolean equiped;

	public PhysicalItemEquiped(PhysicalItem item, boolean equiped) {
		this.item = item;
		this.equiped = equiped;
	}

	public PhysicalItemEquiped() {
	}

	@ManyToOne
	public PhysicalItem getItem() {
		return item;
	}

	public void setItem(PhysicalItem item) {
		this.item = item;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "oid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
