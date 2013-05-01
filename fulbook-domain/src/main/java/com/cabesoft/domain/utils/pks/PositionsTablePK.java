package com.cabesoft.domain.utils.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cabesoft.domain.model.League;
import com.cabesoft.domain.model.Team;
@Embeddable
public class PositionsTablePK  implements Serializable{
    	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@ManyToOne
	    private League league;
		@ManyToOne    
	    private Team team;
	    
	     
	
		public League getLeague() {
			return league;
		}
		public void setLeague(League league) {
			this.league = league;
		}
	
		public Team getTeam() {
			return team;
		}
		public void setTeam(Team team) {
			this.team = team;
		}
		
	    
	    
}
