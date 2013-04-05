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
public class Team {
	private Integer id;
	private String name;
	private String logo;
	
	private League league;
	
	private Set<Player> players;
	
	private Integer leaguePosition;
	
	private Money money;
	
	private Set<TeamItemEquiped> teamItems;
	
	private boolean active;
	

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="oid")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="logo",nullable=false)
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@ManyToOne
	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="team")
	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	@Column(name="league_position")
	public Integer getLeaguePosition() {
		return leaguePosition;
	}

	public void setLeaguePosition(Integer leaguePosition) {
		this.leaguePosition = leaguePosition;
	}
	@Embedded
	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	public Set<TeamItemEquiped> getTeamItems() {
		return teamItems;
	}

	public void setTeamItems(Set<TeamItemEquiped> teamItems) {
		this.teamItems = teamItems;
	}
	@Column(name="active", nullable=false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
