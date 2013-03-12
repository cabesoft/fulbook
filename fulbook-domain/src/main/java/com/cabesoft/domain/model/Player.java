package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cabesoft.domain.enums.PlayerBehavior;

@Entity
@Table(name="Player")
public class Player {
	
	
	@Id
    @GeneratedValue
    private Long id;
    @Column(name="name")
    private String name;
    
    private List<PhysicalStatAmount> physicalStats;
    
    private List<SocialStatAmount> socialStats;
    
    private PlayerBehavior behavior;
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team team;
    
    private List<PlayerPosition> playerPosition;
    
    private Integer experience;
    
    private Integer level;
 
	private Money money;
    @OneToMany
    private List<PlayerPhysicalItem> physicalItems;
    
    private List<PlayerSocialItem> socialItems;  
    
    private Integer physicalEnergy;
    
    private Integer socialEnergy;
    
    private Integer competitiveEnergy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PhysicalStatAmount> getPhysicalStats() {
		return physicalStats;
	}

	public void setPhysicalStats(List<PhysicalStatAmount> physicalStats) {
		this.physicalStats = physicalStats;
	}

	public List<SocialStatAmount> getSocialStats() {
		return socialStats;
	}

	public void setSocialStats(List<SocialStatAmount> socialStats) {
		this.socialStats = socialStats;
	}

	public PlayerBehavior getBehavior() {
		return behavior;
	}

	public void setBehavior(PlayerBehavior behavior) {
		this.behavior = behavior;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<PlayerPosition> getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(List<PlayerPosition> playerPosition) {
		this.playerPosition = playerPosition;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public List<PlayerPhysicalItem> getPhysicalItems() {
		return physicalItems;
	}

	public void setPhysicalItems(List<PlayerPhysicalItem> physicalItems) {
		this.physicalItems = physicalItems;
	}

	public List<PlayerSocialItem> getSocialItems() {
		return socialItems;
	}

	public void setSocialItems(List<PlayerSocialItem> socialItems) {
		this.socialItems = socialItems;
	}

	public Integer getPhysicalEnergy() {
		return physicalEnergy;
	}

	public void setPhysicalEnergy(Integer physicalEnergy) {
		this.physicalEnergy = physicalEnergy;
	}

	public Integer getSocialEnergy() {
		return socialEnergy;
	}

	public void setSocialEnergy(Integer socialEnergy) {
		this.socialEnergy = socialEnergy;
	}

	public Integer getCompetitiveEnergy() {
		return competitiveEnergy;
	}

	public void setCompetitiveEnergy(Integer competitiveEnergy) {
		this.competitiveEnergy = competitiveEnergy;
	}
}
