package com.cabesoft.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;

import com.cabesoft.domain.enums.FieldPosition;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PlayerBehavior;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.utils.Money;

@Entity
public class Player {

	private Integer id;

	private String name;

	private Map<PhysicalSlot, PhysicalItem> bodyParts;

	private Map<SocialSlot, SocialItem> socialParts;

	private Team team;

	private Integer physicalEnergy;

	private Integer competitiveEnergy;

	private Integer socialEnergy;

	private Integer level;

	private Integer expirience;

	private PlayerBehavior behavior;

	private Money money;

	private Set<SocialStatAmount> socialStatAmounts;

	private Set<PhysicalStatAmount> physicalStatAmounts;

	private FieldPosition position;
	// puntos en cada una de las posiciones para ese campeonato

	private Integer goalKeeperPoints;

	private Integer defensePoints;

	private Integer attackPoints;

	// puntos en el ranking de cada una de las posiciones

	private Integer goalKeeperRankingPoints;

	private Integer defenseRankingPoints;

	private Integer attackRankingPoints;

	private String face;

	private Set<PhysicalItem> physicalItems;
	private Set<SocialItem> socialItems;

	private Integer physicalPointsToAsign;

	private Integer socialPointsToAsign;

	@OneToMany
	@JoinTable(name = "player_physical_invetory")
	public Set<PhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	@OneToMany
	@JoinTable(name = "player_social_invetory")
	public Set<SocialItem> getSocialItems() {
		return socialItems;
	}

	public void setPhysicalItems(Set<PhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public void setSocialItems(Set<SocialItem> socialItems) {
		this.socialItems = socialItems;
	}

	public Player(String name, String face,
			Set<SocialStatAmount> socialStatAmounts,
			Set<PhysicalStatAmount> physicalStatAmounts) {
		this.name = name;
		this.socialStatAmounts = socialStatAmounts;
		this.physicalStatAmounts = physicalStatAmounts;
		this.attackPoints = 0;
		this.attackRankingPoints = 0;
		this.defensePoints = 0;
		this.defenseRankingPoints = 0;
		this.goalKeeperPoints = 0;
		this.goalKeeperRankingPoints = 0;
		this.competitiveEnergy = 0;
		this.socialEnergy = 0;
		this.physicalEnergy = 0;
		this.expirience = 0;
		this.level = 1;
		this.money = new Money(100, 10);
		this.face = face;
		this.physicalPointsToAsign=0;
		this.socialPointsToAsign=0;
		this.setPhysicalItems(new HashSet<PhysicalItem>());
		this.setSocialItems(new HashSet<SocialItem>());
		this.setBodyParts(new HashMap<PhysicalSlot,PhysicalItem>());
		this.setSocialParts(new HashMap<SocialSlot,SocialItem>());
	}

	public Player() {
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@ManyToOne
	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Column(name = "level", nullable = false)
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "expirience", nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<SocialStatAmount> getSocialStatAmounts() {
		return socialStatAmounts;
	}

	public void setSocialStatAmounts(Set<SocialStatAmount> socialStatAmounts) {
		this.socialStatAmounts = socialStatAmounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<PhysicalStatAmount> getPhysicalStatAmounts() {
		return physicalStatAmounts;
	}

	public void setPhysicalStatAmounts(
			Set<PhysicalStatAmount> physicalStatAmounts) {
		this.physicalStatAmounts = physicalStatAmounts;
	}

	@Column(name = "physical_energy", nullable = false)
	public Integer getPhysicalEnergy() {
		return physicalEnergy;
	}

	public void setPhysicalEnergy(Integer physicalEnergy) {
		this.physicalEnergy = physicalEnergy;
	}

	@Column(name = "competitive_energy", nullable = false)
	public Integer getCompetitiveEnergy() {
		return competitiveEnergy;
	}

	public void setCompetitiveEnergy(Integer competitiveEnergy) {
		this.competitiveEnergy = competitiveEnergy;
	}

	@Column(name = "social_energy", nullable = false)
	public Integer getSocialEnergy() {
		return socialEnergy;
	}

	public void setSocialEnergy(Integer socialEnergy) {
		this.socialEnergy = socialEnergy;
	}

	@Column(name = "goalkeeper_points", nullable = false)
	public Integer getGoalKeeperPoints() {
		return goalKeeperPoints;
	}

	public void setGoalKeeperPoints(Integer goalKeeperPoints) {
		this.goalKeeperPoints = goalKeeperPoints;
	}

	@Column(name = "defense_points", nullable = false)
	public Integer getDefensePoints() {
		return defensePoints;
	}

	public void setDefensePoints(Integer defensePoints) {
		this.defensePoints = defensePoints;
	}

	@Column(name = "attack_points", nullable = false)
	public Integer getAttackPoints() {
		return attackPoints;
	}

	public void setAttackPoints(Integer attackPoints) {
		this.attackPoints = attackPoints;
	}

	@Column(name = "goalkeeper_ranking_points", nullable = false)
	public Integer getGoalKeeperRankingPoints() {
		return goalKeeperRankingPoints;
	}

	public void setGoalKeeperRankingPoints(Integer goalKeeperRankingPoints) {
		this.goalKeeperRankingPoints = goalKeeperRankingPoints;
	}

	@Column(name = "defense_ranking_points", nullable = false)
	public Integer getDefenseRankingPoints() {
		return defenseRankingPoints;
	}

	public void setDefenseRankingPoints(Integer defenseRankingPoints) {
		this.defenseRankingPoints = defenseRankingPoints;
	}

	@Column(name = "attack_ranking_points", nullable = false)
	public Integer getAttackRankingPoints() {
		return attackRankingPoints;
	}

	public void setAttackRankingPoints(Integer attackRankingPoints) {
		this.attackRankingPoints = attackRankingPoints;
	}

	@Enumerated(EnumType.STRING)
	public FieldPosition getPosition() {
		return position;
	}

	public void setPosition(FieldPosition position) {
		this.position = position;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@MapKeyClass(value = PhysicalSlot.class)
	public Map<PhysicalSlot, PhysicalItem> getBodyParts() {
		return bodyParts;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@MapKeyClass(value = SocialSlot.class)
	public Map<SocialSlot, SocialItem> getSocialParts() {
		return socialParts;
	}

	public void setBodyParts(Map<PhysicalSlot, PhysicalItem> bodyParts) {
		this.bodyParts = bodyParts;
	}

	public void setSocialParts(Map<SocialSlot, SocialItem> socialParts) {
		this.socialParts = socialParts;
	}

	public Integer getPhysicalPointsToAsign() {
		return physicalPointsToAsign;
	}

	public Integer getSocialPointsToAsign() {
		return socialPointsToAsign;
	}

	public void setPhysicalPointsToAsign(Integer physicalPointsToAsign) {
		this.physicalPointsToAsign = physicalPointsToAsign;
	}

	public void setSocialPointsToAsign(Integer socialPointsToAsign) {
		this.socialPointsToAsign = socialPointsToAsign;
	}

}
