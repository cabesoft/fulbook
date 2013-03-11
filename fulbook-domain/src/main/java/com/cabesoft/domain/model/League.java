package com.cabesoft.domain.model;

import java.util.List;


public class League {
	
	private String name;
	
	private String description;
	
	private League parent;
	
	private League son;
	
	private List<Team> teams;
	
	private List<Match> matches;
	

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public League getParent() {
		return parent;
	}

	public League getSon() {
		return son;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParent(League parent) {
		this.parent = parent;
	}

	public void setSon(League son) {
		this.son = son;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}


	

}
