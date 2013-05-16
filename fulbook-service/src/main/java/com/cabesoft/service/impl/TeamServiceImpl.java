package com.cabesoft.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.cabesoft.domain.dao.TeamDao;
import com.cabesoft.domain.enums.FieldPosition;
import com.cabesoft.domain.model.Team;
import com.cabesoft.model.dto.MoneyDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.TeamDTO;
import com.cabesoft.service.LeagueService;
import com.cabesoft.service.PlayerService;
import com.cabesoft.service.TeamService;
import com.cabesoft.service.impl.utils.LeaguePositionResponse;

public class TeamServiceImpl implements TeamService {
	private Mapper mapper;
	private TeamDao teamDao;
	private PlayerService playerService;
	private LeagueService leagueService;
	private static final Logger LOGGER = Logger
			.getLogger(TeamServiceImpl.class);
	private static final int INITIAL_FAKE_MONEY = 0;
	private static final int INITIAL_TOKEN_MONEY = 0;

	public TeamDTO createTeam(Integer captainId, String name, String logo) {
		PlayerDTO captain = this.playerService.getPlayerById(captainId);

		if (captain != null && checkNameAvailability(name)
				&& checkPlayerHasNoTeam(captain)) {
			TeamDTO teamDTO = new TeamDTO();
			teamDTO.setActive(true);

			// FIXME: esto puede generar problemas de concurrencia!?!
			LeaguePositionResponse leagueResponse = this.leagueService
					.getLeagueWithAvailablePosition();

			teamDTO.setLeague(leagueResponse.getLeague());
			teamDTO.setLeaguePosition(leagueResponse.getPosition());
			teamDTO.setLogo(logo);
			teamDTO.setMoney(new MoneyDTO(INITIAL_FAKE_MONEY,
					INITIAL_TOKEN_MONEY));
			teamDTO.setName(name);
			Set<PlayerDTO> players = new HashSet<PlayerDTO>();
			players.add(captain);
			teamDTO.setPlayers(players);

			Team team = this.mapper.map(teamDTO, Team.class);
			Integer teamId = (Integer) this.teamDao.save(team);
			teamDTO.setId(teamId);
			return teamDTO;
		}
		return null;

	}

	public void deactivateTeam(Integer teamId) {
		this.teamDao.deactivateTeam(teamId);
	}

	public void changePlayerPosition(Long playerId, FieldPosition position,
			Long teamId) {

	}

	private boolean checkNameAvailability(String name) {
		try {
			Team team = this.teamDao.getTeamByName(name);
			return (team != null);
		} catch (Exception e) {
			LOGGER.error("Error checking team name availability", e);
			return false;
		}
	}

	private boolean checkPlayerHasNoTeam(PlayerDTO captain) {
		return captain.getTeam() == null;
	}

}
