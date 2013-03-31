package com.cabesoft.domain.utils.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cabesoft.domain.model.League;
import com.cabesoft.domain.model.Team;

@Embeddable
public class GamePK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7506655721342479405L;
	
	@ManyToOne
	private League league;
	@ManyToOne
	private Team local;
	@ManyToOne
	private Team visitors;
	private Integer date;
	
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
	public Team getVisitors() {
		return visitors;
	}
	public void setVisitors(Team visitors) {
		this.visitors = visitors;
	}
	public Integer getDate() {
		return date;
	}
	public void setDate(Integer date) {
		this.date = date;
	}
	
}
