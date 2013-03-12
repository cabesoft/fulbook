package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.model.utils.MatchPK;

@Entity
@IdClass(MatchPK.class)
public class Match {
	@Id
	private League league;
	@Id
	private Team local;
	@Id	
	private Team visitor;
	@Id	
	private Integer season;
	@Id	
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
