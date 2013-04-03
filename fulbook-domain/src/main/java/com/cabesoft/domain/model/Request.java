package com.cabesoft.domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import com.cabesoft.domain.utils.pks.RequestPK;

/*
 * This request is made by the player to join a  team
 * 
 * */
@Entity

public class Request {
	@EmbeddedId
	 private RequestPK requestPK;
	 private Date date_created;
	 private boolean team_requested;
	 
	@Column(name = "date_created", nullable = false)
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	@Column(name = "team_requested", nullable = false)
	public boolean isTeam_requested() {
		return team_requested;
	}
	public void setTeam_requested(boolean team_requested) {
		this.team_requested = team_requested;
	}

	public RequestPK getRequestPK() {
		return requestPK;
	}

	public void setRequestPK(RequestPK requestPK) {
		this.requestPK = requestPK;
	}
	 

}
