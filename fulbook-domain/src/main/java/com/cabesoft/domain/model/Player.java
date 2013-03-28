package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cabesoft.domain.utils.Money;
@Entity
public class Player {
	
	private Integer id;
	
	private String name;
	
	private  Set<PhysicalItem> physicalItems;
	
	private  Set<SocialItem> socialItems;
	
	private Team team;

	private Integer physical_energy;
	
	private Integer competitive_energy;
	
	private Integer social_energy;
	
	private Integer level;
	
	private Integer expirience;
	


	private Money money;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<PhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	public void setPhysicalItems(Set<PhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<SocialItem> getSocialItems() {
		return socialItems;
	}

	public void setSocialItems(Set<SocialItem> socialItems) {
		this.socialItems = socialItems;
	}

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
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getPhysical_energy() {
		return physical_energy;
	}

	public void setPhysical_energy(Integer physical_energy) {
		this.physical_energy = physical_energy;
	}

	public Integer getCompetitive_energy() {
		return competitive_energy;
	}

	public void setCompetitive_energy(Integer competitive_energy) {
		this.competitive_energy = competitive_energy;
	}

	public Integer getSocial_energy() {
		return social_energy;
	}

	public void setSocial_energy(Integer social_energy) {
		this.social_energy = social_energy;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getExpirience() {
		return expirience;
	}

	public void setExpirience(Integer expirience) {
		this.expirience = expirience;
	}

	@Embedded 
	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

}
