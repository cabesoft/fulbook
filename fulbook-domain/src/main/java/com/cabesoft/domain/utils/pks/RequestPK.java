package com.cabesoft.domain.utils.pks;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.Team;
@Embeddable
public class RequestPK implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	 private Player player;
	 @ManyToOne
	 private Team team;
	 
	public Player getPlayer() {
		return player;
	}
	public Team getTeam() {
		return team;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
