package com.cabesoft.domain.dao;

import com.cabesoft.domain.model.Team;

public interface TeamDao extends GenericDao<Team> {
	Team getTeamByName(String name);

	void deactivateTeam(Integer teamId);
}
