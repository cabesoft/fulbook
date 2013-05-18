package com.cabesoft.model.dto;

import java.util.List;
import java.util.Map;

import com.cabesoft.domain.enums.FieldPosition;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.enums.PlayerBehavior;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.SocialStat;

public class PlayerDTO {
	private Integer id;

	private String name;

	private TeamDTO team;

	private Integer physicalEnergy;

	private Map<PhysicalSlot, PhysicalItemDTO> bodyParts;

	private Map<SocialSlot, SocialItemDTO> socialParts;

	private Integer competitiveEnergy;

	private Integer socialEnergy;

	private String face;

	private Integer level;

	private Integer expirience;

	private PlayerBehavior behavior;

	private MoneyDTO money;

	private Map<SocialStat, Integer> socialStatAmounts;

	private Map<PhysicalStat, Integer> physicalStatAmounts;

	private FieldPosition position;
	// puntos en cada una de las posiciones para ese campeonato

	private Integer goalKeeperPoints;

	private Integer defensePoints;

	private Integer attackPoints;

	// puntos en el ranking de cada una de las posiciones

	private Integer goalKeeperRankingPoints;

	private Integer defenseRankingPoints;

	private Integer attackRankingPoints;

	private Integer physicalPointsToAsign;
	private Integer socialPointsToAsign;

	private List<PhysicalItemDTO> physicalItems;
	private List<SocialItemDTO> socialItems;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
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

	public TeamDTO getTeam() {
		return team;
	}

	public Integer getPhysicalEnergy() {
		return physicalEnergy;
	}

	public void setTeam(TeamDTO team) {
		this.team = team;
	}

	public void setPhysicalEnergy(Integer physicalEnergy) {
		this.physicalEnergy = physicalEnergy;
	}

	public Map<PhysicalSlot, PhysicalItemDTO> getBodyParts() {
		return bodyParts;
	}

	public Map<SocialSlot, SocialItemDTO> getSocialParts() {
		return socialParts;
	}

	public List<PhysicalItemDTO> getPhysicalItems() {
		return physicalItems;
	}

	public List<SocialItemDTO> getSocialItems() {
		return socialItems;
	}

	public void setBodyParts(Map<PhysicalSlot, PhysicalItemDTO> bodyParts) {
		this.bodyParts = bodyParts;
	}

	public void setSocialParts(Map<SocialSlot, SocialItemDTO> socialParts) {
		this.socialParts = socialParts;
	}

	public void setPhysicalItems(List<PhysicalItemDTO> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public void setSocialItems(List<SocialItemDTO> socialItems) {
		this.socialItems = socialItems;
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

	public Map<SocialStat, Integer> getSocialStatAmounts() {
		return socialStatAmounts;
	}

	public Map<PhysicalStat, Integer> getPhysicalStatAmounts() {
		return physicalStatAmounts;
	}

	public void setSocialStatAmounts(Map<SocialStat, Integer> socialStatAmounts) {
		this.socialStatAmounts = socialStatAmounts;
	}

	public void setPhysicalStatAmounts(
			Map<PhysicalStat, Integer> physicalStatAmounts) {
		this.physicalStatAmounts = physicalStatAmounts;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

}
