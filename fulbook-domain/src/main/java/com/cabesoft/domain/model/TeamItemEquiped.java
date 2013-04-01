package com.cabesoft.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="team_item_equiped")
public class TeamItemEquiped {
	private Integer id;
	
	private TeamItem item;
	
	private boolean equiped;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="oid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@ManyToOne
	public TeamItem getItem() {
		return item;
	}

	public void setItem(TeamItem item) {
		this.item = item;
	}

	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}
	

}
