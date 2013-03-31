package com.cabesoft.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.PlayerBehavior;
import com.cabesoft.domain.utils.Money;
@Entity
public class Player {
	
	private Integer id;
	
	private String name;
	
	private  Set<PhysicalItemEquiped> physicalItems;
	
	private  Set<SocialItemEquiped> socialItems;
	
	private Team team;

	private Integer physicalEnergy;
	
	private Integer competitiveEnergy;
	
	private Integer socialEnergy;
	
	private Integer level;
	
	private Integer expirience;
	
	private PlayerBehavior behavior;

	private Money money;
	
	private  Set<SocialStatAmount> socialStatAmounts;
	
	private  Set<PhysicalStatAmount> physicalStatAmounts;
	
	// puntos en cada  una de las posiciones para ese campeonato
	
	private Integer goalKeeperPoints;
	
	private Integer defensePoints;
	
	private Integer attackPoints;
	
	//puntos en el ranking de cada una de las posiciones
	
	private Integer goalKeeperRankingPoints;
	
	private Integer defenseRankingPoints;
	
	private Integer attackRankingPoints;
	


	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<PhysicalItemEquiped> getPhysicalItems() {
		return physicalItems;
	}

	public void setPhysicalItems(Set<PhysicalItemEquiped> physicalItems) {
		this.physicalItems = physicalItems;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<SocialItemEquiped> getSocialItems() {
		return socialItems;
	}

	public void setSocialItems(Set<SocialItemEquiped> socialItems) {
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
	@Enumerated(EnumType.STRING)
	public PlayerBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(PlayerBehavior behavior) {
		this.behavior = behavior;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<SocialStatAmount> getSocialStatAmounts() {
		return socialStatAmounts;
	}

	public void setSocialStatAmounts(Set<SocialStatAmount> socialStatAmounts) {
		this.socialStatAmounts = socialStatAmounts;
	}
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<PhysicalStatAmount> getPhysicalStatAmounts() {
		return physicalStatAmounts;
	}

	public void setPhysicalStatAmounts(Set<PhysicalStatAmount> physicalStatAmounts) {
		this.physicalStatAmounts = physicalStatAmounts;
	}

	public Integer getPhysicalEnergy() {
		return physicalEnergy;
	}

	public void setPhysicalEnergy(Integer physicalEnergy) {
		this.physicalEnergy = physicalEnergy;
	}

	public Integer getCompetitiveEnergy() {
		return competitiveEnergy;
	}

	public void setCompetitiveEnergy(Integer competitiveEnergy) {
		this.competitiveEnergy = competitiveEnergy;
	}

	public Integer getSocialEnergy() {
		return socialEnergy;
	}

	public void setSocialEnergy(Integer socialEnergy) {
		this.socialEnergy = socialEnergy;
	}

	public Integer getGoalKeeperPoints() {
		return goalKeeperPoints;
	}

	public void setGoalKeeperPoints(Integer goalKeeperPoints) {
		this.goalKeeperPoints = goalKeeperPoints;
	}

	public Integer getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(Integer defensePoints) {
		this.defensePoints = defensePoints;
	}

	public Integer getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(Integer attackPoints) {
		this.attackPoints = attackPoints;
	}

	public Integer getGoalKeeperRankingPoints() {
		return goalKeeperRankingPoints;
	}

	public void setGoalKeeperRankingPoints(Integer goalKeeperRankingPoints) {
		this.goalKeeperRankingPoints = goalKeeperRankingPoints;
	}

	public Integer getDefenseRankingPoints() {
		return defenseRankingPoints;
	}

	public void setDefenseRankingPoints(Integer defenseRankingPoints) {
		this.defenseRankingPoints = defenseRankingPoints;
	}

	public Integer getAttackRankingPoints() {
		return attackRankingPoints;
	}

	public void setAttackRankingPoints(Integer attackRankingPoints) {
		this.attackRankingPoints = attackRankingPoints;
	}


}
