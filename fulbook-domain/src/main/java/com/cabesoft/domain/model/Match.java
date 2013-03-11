package com.cabesoft.domain.model;

public class Match {

	private League league;
	private Team local;
	private Team visitor;
	private Integer season;
	private Integer date;
	private Integer localGoals;
	private Integer visitorGoals;
	

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Team getLocal() {
		return local;
	}

	public void setLocal(Team local) {
		this.local = local;
	}

	public Team getVisitor() {
		return visitor;
	}

	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}

	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public Integer getLocalGoals() {
		return localGoals;
	}

	public void setLocalGoals(Integer localGoals) {
		this.localGoals = localGoals;
	}

	public Integer getVisitorGoals() {
		return visitorGoals;
	}

	public void setVisitorGoals(Integer visitorGoals) {
		this.visitorGoals = visitorGoals;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}
}
