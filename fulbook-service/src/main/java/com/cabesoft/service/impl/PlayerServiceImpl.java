package com.cabesoft.service.impl;

import java.util.Collection;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Required;

import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.domain.utils.Money;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
import com.cabesoft.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	private Mapper mapper;
	private PlayerDao playerDao;
	private static final Integer ZERO = 0;
	private static final Integer ONE = 1;
	private static final Integer PHYSICAL_ENERGY = 100;
	private static final Integer SOCIAL_ENERGY = 3;
	private static final Integer COMPETITVE_ENERGY = 3;
	private static final Integer PHYSICAL_STATS_AMOUNT = 20;
	private static final Integer SOCIAL_STATS_AMOUNT = 5;
	private static final Integer FAKE_MONEY = 100;
	private static final Integer TOKEN_MONEY = 5;
	private static final int[] expirienceArray = { 0, 50, 100, 300 };

	public PlayerDTO getPlayerByName(String name) {
		Player player = this.playerDao.getPlayerByName(name);
		return mapper.map(player, PlayerDTO.class);
	}

	public PlayerDTO createPlayer(String name, String face,
			Collection<PhysicalStatAmount> physicalStatAmounts,
			Collection<SocialStatAmount> socialStatAmount) {
		if (this.verifyPhysicalStatAmount(physicalStatAmounts)
				&& this.verifySocialStatAmount(socialStatAmount)
				&& this.checkNameAvailable(name)) {
			Player player = new Player();
			player.setName(name);
			player.setFace(face);
			player.setAttackPoints(ZERO);
			player.setAttackRankingPoints(ZERO);
			player.setGoalKeeperPoints(ZERO);
			player.setGoalKeeperRankingPoints(ZERO);
			player.setDefensePoints(ZERO);
			player.setDefenseRankingPoints(ZERO);
			player.setLevel(ONE);
			player.setExpirience(ZERO);
			player.setPhysicalEnergy(PHYSICAL_ENERGY);
			player.setSocialEnergy(SOCIAL_ENERGY);
			player.setCompetitiveEnergy(COMPETITVE_ENERGY);
			player.setMoney((new Money(FAKE_MONEY, TOKEN_MONEY)));
			this.playerDao.save(player);
			return this.mapper.map(player, PlayerDTO.class);
		} else {
			return null;
		}

	}

	public boolean checkNameAvailable(String name) {
		Player player = this.playerDao.getPlayerByName(name);
		return player != null;
	}

	public void addExpirience(PlayerDTO playerDTO, Integer amount) {
		playerDTO.setExpirience(playerDTO.getExpirience() + amount);
		int level = 1;
		while (playerDTO.getExpirience() > expirienceArray[level]) {
			level++;
		}
		playerDTO.setLevel(level);
		Player player = this.mapper.map(playerDTO, Player.class);
		this.playerDao.update(player);
	}

	public boolean equipPhysicalItem(PlayerDTO player,
			PhysicalItemDTO physicalItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean equipSocialItem(PlayerDTO player, SocialItemDTO physicalItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unEquipPhysicalItem(PlayerDTO player,
			PhysicalItemDTO physicalItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unEquipSocialItem(PlayerDTO player,
			SocialItemDTO physicalItem) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addPointToPhysicalStat(PlayerDTO challenger,
			PhysicalStatDTO PhysicalStat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Required
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Required
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	private boolean verifySocialStatAmount(
			Collection<SocialStatAmount> socialStatAmounts) {
		// TODO aca se podria verificar que existan todas las caracteristicas
		Integer acum = 0;
		for (SocialStatAmount socialStatAmount : socialStatAmounts) {
			acum = acum + socialStatAmount.getAmount();
		}
		return acum == SOCIAL_STATS_AMOUNT;
	}

	private boolean verifyPhysicalStatAmount(
			Collection<PhysicalStatAmount> physicalStatAmounts) {
		// TODO aca se podria verificar que existan todas las caracteristicas
		Integer acum = 0;
		for (PhysicalStatAmount physicalStatAmount : physicalStatAmounts) {
			acum = acum + physicalStatAmount.getAmount();
		}
		return acum == PHYSICAL_STATS_AMOUNT;
	}

	public PlayerDTO getPlayerById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
