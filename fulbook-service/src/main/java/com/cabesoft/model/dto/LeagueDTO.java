package com.cabesoft.model.dto;

import java.util.Set;


public class LeagueDTO {
	private Integer id;
	private String name;
	private Set<TeamDTO> teams;
	private LeagueDTO parent;
	private LeagueDTO child;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<TeamDTO> getTeams() {
		return teams;
	}
	public void setTeams(Set<TeamDTO> teams) {
		this.teams = teams;
	}
	public LeagueDTO getParent() {
		return parent;
	}
	public void setParent(LeagueDTO parent) {
		this.parent = parent;
	}
	public LeagueDTO getChild() {
		return child;
	}
	public void setChild(LeagueDTO child) {
		this.child = child;
	}
}
