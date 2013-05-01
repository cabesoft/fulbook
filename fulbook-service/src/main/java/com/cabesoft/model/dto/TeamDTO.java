package com.cabesoft.model.dto;

import java.util.Set;

public class TeamDTO {

	private Integer id;
	private String name;
	private String logo;

	private LeagueDTO league;

	private Set<PlayerDTO> players;

	private Integer leaguePosition;

	private MoneyDTO money;

	private Set<TeamItemEquipedDTO> teamItems;

	private boolean active;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLogo() {
		return logo;
	}

	public LeagueDTO getLeague() {
		return league;
	}

	public Set<PlayerDTO> getPlayers() {
		return players;
	}

	public Integer getLeaguePosition() {
		return leaguePosition;
	}

	public MoneyDTO getMoney() {
		return money;
	}

	public Set<TeamItemEquipedDTO> getTeamItems() {
		return teamItems;
	}

	public boolean isActive() {
		return active;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setLeague(LeagueDTO league) {
		this.league = league;
	}

	public void setPlayers(Set<PlayerDTO> players) {
		this.players = players;
	}

	public void setLeaguePosition(Integer leaguePosition) {
		this.leaguePosition = leaguePosition;
	}

	public void setMoney(MoneyDTO money) {
		this.money = money;
	}

	public void setTeamItems(Set<TeamItemEquipedDTO> teamItems) {
		this.teamItems = teamItems;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
