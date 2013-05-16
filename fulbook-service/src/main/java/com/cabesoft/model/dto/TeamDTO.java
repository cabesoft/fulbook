package com.cabesoft.model.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cabesoft.domain.enums.TeamSlot;

public class TeamDTO {

	private Integer id;
	private String name;
	private String logo;

	private LeagueDTO league;

	private Set<PlayerDTO> players;

	private Integer leaguePosition;

	private MoneyDTO money;

	private boolean active;

	private Map<TeamSlot, TeamItemDTO> itemsEquiped;

	private List<TeamItemDTO> teamItems;

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

	public void setActive(boolean active) {
		this.active = active;
	}

	public Map<TeamSlot, TeamItemDTO> getItemsEquiped() {
		return itemsEquiped;
	}

	public void setTeamItems(Map<TeamSlot, TeamItemDTO> itemsEquiped) {
		this.itemsEquiped = itemsEquiped;
	}

	public List<TeamItemDTO> getTeamItems() {
		return teamItems;
	}

	public void setItemsEquiped(List<TeamItemDTO> teamItems) {
		this.teamItems = teamItems;
	}

}
