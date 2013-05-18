package com.cabesoft.service.impl.utils;

import com.cabesoft.domain.model.Player;
import com.cabesoft.model.dto.PlayerDTO;

public class PlayerMapper {
	// TODO esto se tendria que inyectar por spring
	private SocialItemMapper socialItemMapper = new SocialItemMapper();
	private PhysicalItemMapper physicalItemMapper = new PhysicalItemMapper();
	private MoneyMapper moneyMapper = new MoneyMapper();
	private PhysicalStatAmountMapper physicalStatAmountMapper = new PhysicalStatAmountMapper();
	private SocialStatAmountMapper socialStatAmountMapper = new SocialStatAmountMapper();

	// TODO agregar el team mapper
	public Player toModel(PlayerDTO playerDTO) {
		Player player = new Player();
		player.setAttackPoints(playerDTO.getAttackPoints());
		player.setAttackRankingPoints(playerDTO.getAttackRankingPoints());
		player.setBehavior(playerDTO.getBehavior());
		player.setCompetitiveEnergy(playerDTO.getCompetitiveEnergy());
		player.setDefensePoints(playerDTO.getDefensePoints());
		player.setDefenseRankingPoints(playerDTO.getDefenseRankingPoints());
		player.setExpirience(playerDTO.getExpirience());
		player.setFace(playerDTO.getFace());
		player.setGoalKeeperPoints(playerDTO.getGoalKeeperPoints());
		player.setGoalKeeperRankingPoints(playerDTO
				.getGoalKeeperRankingPoints());
		player.setId(playerDTO.getId());
		player.setMoney(moneyMapper.toModel(playerDTO.getMoney()));
		player.setLevel(playerDTO.getLevel());
		player.setName(playerDTO.getName());
		player.setPhysicalEnergy(playerDTO.getPhysicalEnergy());
		player.setPhysicalPointsToAsign(playerDTO.getPhysicalPointsToAsign());
		player.setPosition(playerDTO.getPosition());
		player.setSocialEnergy(playerDTO.getSocialEnergy());
		player.setSocialPointsToAsign(playerDTO.getSocialPointsToAsign());
		player.setPhysicalStatAmounts(physicalStatAmountMapper
				.toModel(playerDTO.getPhysicalStatAmounts()));
		player.setSocialStatAmounts(socialStatAmountMapper.toModel(playerDTO
				.getSocialStatAmounts()));
		// player.setTeam(team)
		return player;

	}
}
