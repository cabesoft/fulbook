package com.cabesoft.service.impl;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Required;

import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.domain.utils.Money;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatAmountDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
import com.cabesoft.model.dto.SocialStatAmountDTO;
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
	private static final int INVENTORY_SIZE = 5;
	private static final Integer PHYSICAL_POINTS_TO_ADD_PER_LEVEL = 5;
	private static final Integer SOCIAL_POINTS_TO_ADD_PER_LEVEL = 3;
	private static final double LOGARITHM_BASE = 3;

	public PlayerDTO getPlayerByName(String name) {
		Player player = this.playerDao.getPlayerByName(name);
		return mapper.map(player, PlayerDTO.class);
	}

	public PlayerDTO createPlayer(String name, String face,
			Set<PhysicalStatAmount> physicalStatAmounts,
			Set<SocialStatAmount> socialStatAmount) {
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
			player.setSocialStatAmounts(socialStatAmount);
			player.setPhysicalStatAmounts(physicalStatAmounts);
			this.playerDao.save(player);
			return this.mapper.map(player, PlayerDTO.class);
		} else {
			return null;
		}

	}

	public PlayerDTO getPlayerById(Integer id) {
		return this.mapper.map(this.playerDao.get(id), PlayerDTO.class);
	}

	public boolean checkNameAvailable(String name) {
		Player player = this.playerDao.getPlayerByName(name);
		return player == null;
	}

	public void addExpirience(PlayerDTO playerDTO, Integer amount) {
		Integer previousLevel = playerDTO.getLevel();
		playerDTO.setExpirience(playerDTO.getExpirience() + amount);
		// calculo el nivel nuevo con la experiencia sumada
		Integer newLevel = this.calculateLevel(playerDTO);
		playerDTO.setLevel(newLevel);

		int i;
		// por cada nivel que subio le sumo puntos que se puede agregar!
		for (i = 0; i < newLevel - previousLevel; i++) {
			playerDTO.setPhysicalPointsToAsign(playerDTO
					.getPhysicalPointsToAsign()
					+ PHYSICAL_POINTS_TO_ADD_PER_LEVEL);
			playerDTO.setSocialPointsToAsign(playerDTO.getSocialPointsToAsign()
					+ SOCIAL_POINTS_TO_ADD_PER_LEVEL);
		}
		Player player = mapper.map(playerDTO, Player.class);
		this.playerDao.update(player);

	}

	public boolean equipPhysicalItem(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItem) {
		boolean succes;
		if (playerDTO.getPhysicalItems().contains(physicalItem)) {
			// verifico si tiene un item en la posicion
			if (playerDTO.getBodyParts().get(physicalItem.getSlot()) != null) {
				PhysicalItemDTO bodyItem = playerDTO.getBodyParts().get(
						physicalItem.getSlot());
				playerDTO.getPhysicalItems().add(bodyItem);
			}
			// en cualquier caso le seteo el item en la body part y lo saco del
			// inventario
			playerDTO.getBodyParts().put(physicalItem.getSlot(), physicalItem);
			playerDTO.getPhysicalItems().remove(physicalItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
			succes = true;

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean equipSocialItem(PlayerDTO playerDTO, SocialItemDTO socialItem) {
		boolean succes;
		if (playerDTO.getSocialItems().contains(socialItem)) {
			// verifico si tiene un item en la posicion
			if (playerDTO.getSocialParts().get(socialItem.getSlot()) != null) {
				SocialItemDTO bodyItem = playerDTO.getSocialParts().get(
						socialItem.getSlot());
				playerDTO.getSocialItems().add(bodyItem);
			}
			// en cualquier caso le seteo el item en la body part y lo saco del
			// inventario
			playerDTO.getSocialParts().put(socialItem.getSlot(), socialItem);
			playerDTO.getSocialItems().remove(socialItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
			succes = true;

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean unEquipPhysicalItem(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItem) {
		boolean succes = false;
		// verifico si lo tiene equipado y si tiene lugar para pasarlo al
		// inventario
		if (physicalItem.equals(playerDTO.getBodyParts().get(
				physicalItem.getSlot()))
				&& this.roomOnInventory(playerDTO)) {
			succes = true;
			playerDTO.getPhysicalItems().add(physicalItem);
			playerDTO.getBodyParts().put(physicalItem.getSlot(), physicalItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
		}
		return succes;
	}

	public boolean unEquipSocialItem(PlayerDTO playerDTO,
			SocialItemDTO socialItem) {
		boolean succes = false;
		// verifico si lo tiene equipado y si tiene lugar para pasarlo al
		// inventario
		if (socialItem.equals(playerDTO.getSocialParts().get(
				socialItem.getSlot()))
				&& this.roomOnInventory(playerDTO)) {
			succes = true;
			playerDTO.getSocialItems().add(socialItem);
			playerDTO.getSocialParts().put(socialItem.getSlot(), socialItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
		}
		return succes;
	}

	public boolean roomOnInventory(PlayerDTO playerDTO) {
		return playerDTO.getSocialItems().size()
				+ playerDTO.getPhysicalItems().size() <= INVENTORY_SIZE;
	}

	public boolean addPointToPhysicalStat(PlayerDTO playerDTO,
			PhysicalStatDTO physicalStat, Integer amount) {
		boolean succes;
		if (playerDTO.getPhysicalPointsToAsign() <= amount) {
			playerDTO.setPhysicalPointsToAsign(playerDTO
					.getPhysicalPointsToAsign() - amount);
			Set<PhysicalStatAmountDTO> physicalStatAmounts = playerDTO
					.getPhysicalStatAmounts();
			boolean sumo = false;
			Iterator<PhysicalStatAmountDTO> iterator = physicalStatAmounts
					.iterator();
			while (!sumo && iterator.hasNext()) {
				PhysicalStatAmountDTO next = iterator.next();
				if (next.getStat().equals(physicalStat)) {
					sumo = true;
					next.setAmount(next.getAmount() + amount);
				}
			}
			// si sumo es que fue exitoso
			this.playerDao.update(this.mapper.map(playerDTO, Player.class));
			succes = sumo;

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean addPointToSocialStat(PlayerDTO playerDTO,
			PhysicalStatDTO socialStat, Integer amount) {
		boolean succes;
		if (playerDTO.getSocialPointsToAsign() <= amount) {
			playerDTO.setSocialPointsToAsign(playerDTO.getSocialPointsToAsign()
					- amount);
			Set<SocialStatAmountDTO> socialStatAmounts = playerDTO
					.getSocialStatAmounts();
			boolean sumo = false;
			Iterator<SocialStatAmountDTO> iterator = socialStatAmounts
					.iterator();
			while (!sumo && iterator.hasNext()) {
				SocialStatAmountDTO next = iterator.next();
				if (next.getStat().equals(socialStat)) {
					sumo = true;
					next.setAmount(next.getAmount() + amount);
				}
			}
			// si sumo es que fue exitoso
			this.playerDao.update(this.mapper.map(playerDTO, Player.class));
			succes = sumo;

		} else {
			succes = false;
		}
		return succes;

	}

	@Required
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}

	@Required
	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	private Integer calculateLevel(PlayerDTO playerDTO) {
		return (int) (Math.log(playerDTO.getExpirience() + LOGARITHM_BASE) / Math
				.log(LOGARITHM_BASE));
	}

	private boolean verifySocialStatAmount(
			Collection<SocialStatAmount> socialStatAmounts) {
		Integer acum = 0;
		for (SocialStatAmount socialStatAmount : socialStatAmounts) {
			acum = acum + socialStatAmount.getAmount();
		}
		return acum == SOCIAL_STATS_AMOUNT;
	}

	private boolean verifyPhysicalStatAmount(
			Collection<PhysicalStatAmount> physicalStatAmounts) {
		Integer acum = 0;
		for (PhysicalStatAmount physicalStatAmount : physicalStatAmounts) {
			acum = acum + physicalStatAmount.getAmount();
		}
		return acum == PHYSICAL_STATS_AMOUNT;
	}

}
