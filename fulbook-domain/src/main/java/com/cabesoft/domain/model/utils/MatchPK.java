package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import com.cabesoft.domain.model.League;
import com.cabesoft.domain.model.Team;

public class MatchPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private League league;
	private Team local;
	private Team visitor;
	private Integer season;
	private Integer date;

	public MatchPK() {
		
	}
	
	

	public MatchPK(League league, Team local, Team visitor, Integer season,
			Integer date) {
		super();
		this.league = league;
		this.local = local;
		this.visitor = visitor;
		this.season = season;
		this.date = date;
	}



	public League getLeague() {
		return league;
	}

	public Team getLocal() {
		return local;
	}

	public Team getVisitor() {
		return visitor;
	}

	public Integer getSeason() {
		return season;
	}

	public Integer getDate() {
		return date;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public void setLocal(Team local) {
		this.local = local;
	}

	public void setVisitor(Team visitor) {
		this.visitor = visitor;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public void setDate(Integer date) {
		this.date = date;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((league == null) ? 0 : league.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((season == null) ? 0 : season.hashCode());
		result = prime * result + ((visitor == null) ? 0 : visitor.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchPK other = (MatchPK) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (league == null) {
			if (other.league != null)
				return false;
		} else if (!league.equals(other.league))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (season == null) {
			if (other.season != null)
				return false;
		} else if (!season.equals(other.season))
			return false;
		if (visitor == null) {
			if (other.visitor != null)
				return false;
		} else if (!visitor.equals(other.visitor))
			return false;
		return true;
	}
	
	

	
	
	
	
}
