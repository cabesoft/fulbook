package com.cabesoft.model.dto;

import java.util.Set;

import com.cabesoft.domain.enums.FieldPosition;
import com.cabesoft.domain.enums.PlayerBehavior;

public class PlayerDTO {
private Integer id;
	
	private String name;
	
	private  Set<PhysicalItemEquipedDTO> physicalItems;
	
	private  Set<SocialItemEquipedDTO> socialItems;
	
	private TeamDTO team;

	private Integer physicalEnergy;
	
	private Integer competitiveEnergy;
	
	private Integer socialEnergy;
	
	private Integer level;
	
	private Integer expirience;
	
	private PlayerBehavior behavior;

	private MoneyDTO money;
	
	private  Set<SocialStatAmountDTO> socialStatAmounts;
	
	private  Set<PhysicalStatAmountDTO> physicalStatAmounts;
	
	private FieldPosition position;
	// puntos en cada  una de las posiciones para ese campeonato
	
	private Integer goalKeeperPoints;
	
	private Integer defensePoints;
	
	private Integer attackPoints;
	
	//puntos en el ranking de cada una de las posiciones
	
	private Integer goalKeeperRankingPoints;
	
	private Integer defenseRankingPoints;
	
	private Integer attackRankingPoints;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<PhysicalItemEquipedDTO> getPhysicalItems() {
		return physicalItems;
	}

	public Set<SocialItemEquipedDTO> getSocialItems() {
		return socialItems;
	}

	public TeamDTO getTeam() {
		return team;
	}

	public Integer getPhysicalEnergy() {
		return physicalEnergy;
	}

	public Integer getCompetitiveEnergy() {
		return competitiveEnergy;
	}

	public Integer getSocialEnergy() {
		return socialEnergy;
	}

	public Integer getLevel() {
		return level;
	}

	public Integer getExpirience() {
		return expirience;
	}

	public PlayerBehavior getBehavior() {
		return behavior;
	}

	public MoneyDTO getMoney() {
		return money;
	}

	public Set<SocialStatAmountDTO> getSocialStatAmounts() {
		return socialStatAmounts;
	}

	public Set<PhysicalStatAmountDTO> getPhysicalStatAmounts() {
		return physicalStatAmounts;
	}

	public FieldPosition getPosition() {
		return position;
	}

	public Integer getGoalKeeperPoints() {
		return goalKeeperPoints;
	}

	public Integer getDefensePoints() {
		return defensePoints;
	}

	public Integer getAttackPoints() {
		return attackPoints;
	}

	public Integer getGoalKeeperRankingPoints() {
		return goalKeeperRankingPoints;
	}

	public Integer getDefenseRankingPoints() {
		return defenseRankingPoints;
	}

	public Integer getAttackRankingPoints() {
		return attackRankingPoints;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhysicalItems(Set<PhysicalItemEquipedDTO> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public void setSocialItems(Set<SocialItemEquipedDTO> socialItems) {
		this.socialItems = socialItems;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public void setPhysicalEnergy(Integer physicalEnergy) {
		this.physicalEnergy = physicalEnergy;
	}

	public void setCompetitiveEnergy(Integer competitiveEnergy) {
		this.competitiveEnergy = competitiveEnergy;
	}

	public void setSocialEnergy(Integer socialEnergy) {
		this.socialEnergy = socialEnergy;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setExpirience(Integer expirience) {
		this.expirience = expirience;
	}

	public void setBehavior(PlayerBehavior behavior) {
		this.behavior = behavior;
	}

	public void setMoney(MoneyDTO money) {
		this.money = money;
	}

	public void setSocialStatAmounts(Set<SocialStatAmountDTO> socialStatAmounts) {
		this.socialStatAmounts = socialStatAmounts;
	}

	public void setPhysicalStatAmounts(
			Set<PhysicalStatAmountDTO> physicalStatAmounts) {
		this.physicalStatAmounts = physicalStatAmounts;
	}

	public void setPosition(FieldPosition position) {
		this.position = position;
	}

	public void setGoalKeeperPoints(Integer goalKeeperPoints) {
		this.goalKeeperPoints = goalKeeperPoints;
	}

	public void setDefensePoints(Integer defensePoints) {
		this.defensePoints = defensePoints;
	}

	public void setAttackPoints(Integer attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setGoalKeeperRankingPoints(Integer goalKeeperRankingPoints) {
		this.goalKeeperRankingPoints = goalKeeperRankingPoints;
	}

	public void setDefenseRankingPoints(Integer defenseRankingPoints) {
		this.defenseRankingPoints = defenseRankingPoints;
	}

	public void setAttackRankingPoints(Integer attackRankingPoints) {
		this.attackRankingPoints = attackRankingPoints;
	}
}
