package com.cabesoft.service;

import com.cabesoft.model.dto.TeamDTO;

public interface TeamService {

	TeamDTO createTeam(Integer captainId, String name, String logo);
}
