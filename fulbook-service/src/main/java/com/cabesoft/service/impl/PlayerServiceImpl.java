package com.cabesoft.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Required;

import com.cabesoft.domain.dao.PhysicalItemDao;
import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.dao.SocialItemDao;
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
import com.cabesoft.service.exception.ValidationException;

public class PlayerServiceImpl implements PlayerService {

	private Mapper mapper;
	private PlayerDao playerDao;
	private PhysicalItemDao physicalItemDao;
	private SocialItemDao socialItemDao;

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
		if (player == null) {
			return null;
		}
		return mapper.map(player, PlayerDTO.class);
	}

	public void createPlayer(String name, String face,
			Set<PhysicalStatAmount> physicalStatAmounts,
			Set<SocialStatAmount> socialStatAmount) throws ValidationException {

		Map<String, String> errors = new HashMap<String, String>();

		this.verifyPhysicalStatAmount(physicalStatAmounts, errors);
		this.verifySocialStatAmount(socialStatAmount, errors);
		if (this.checkNameAvailable(name) == false) {
			errors.put("player", "service.validation.name.not.available");
		}
		;
		if (errors.entrySet().size() == 0) {
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
		} else {
			throw new ValidationException(errors);
		}

	}

	public PlayerDTO getPlayerById(Integer id) {
		return this.mapper.map(this.playerDao.get(id), PlayerDTO.class);
	}

	public boolean checkNameAvailable(String name) {
		Player player = this.playerDao.getPlayerByName(name);
		return player == null;
	}

	public void addExpirience(Integer playerId, Integer amount) {
		PlayerDTO playerDTO = this.getPlayerById(playerId);
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

	public void equipPhysicalItem(Integer playerId, Integer physicalItemId)
			throws ValidationException {
		PhysicalItemDTO physicalItem = this.mapper
				.map(this.physicalItemDao.get(physicalItemId),
						PhysicalItemDTO.class);
		PlayerDTO playerDTO = this.getPlayerById(playerId);
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

		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("equipado",
					"service.validation.player.does.not.have.item");
			throw new ValidationException(errorMap);
		}
	}

	public void equipSocialItem(Integer playerId, Integer socialItemId)
			throws ValidationException {

		SocialItemDTO socialItem = this.mapper.map(
				this.socialItemDao.get(socialItemId), SocialItemDTO.class);
		PlayerDTO playerDTO = this.getPlayerById(playerId);
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

		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("equipado",
					"service.validation.player.does.not.have.item");
			throw new ValidationException(errorMap);
		}
	}

	public void unEquipPhysicalItem(Integer playerId, Integer physicalItemId)
			throws ValidationException {
		// verifico si lo tiene equipado y si tiene lugar para pasarlo al

		PlayerDTO playerDTO = this.getPlayerById(playerId);

		PhysicalItemDTO physicalItem = this.mapper
				.map(this.physicalItemDao.get(physicalItemId),
						PhysicalItemDTO.class);
		// inventario
		if (physicalItem.equals(playerDTO.getBodyParts().get(
				physicalItem.getSlot()))
				&& this.roomOnInventory(playerDTO.getId())) {
			playerDTO.getPhysicalItems().add(physicalItem);
			playerDTO.getBodyParts().put(physicalItem.getSlot(), physicalItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("equipado",
					"service.validation.player.does.not.have.item.equiped");
			throw new ValidationException(errorMap);
		}
	}

	public void unEquipSocialItem(Integer playerId, Integer socialItemId)
			throws ValidationException {
		PlayerDTO playerDTO = this.getPlayerById(playerId);

		SocialItemDTO socialItem = this.mapper.map(
				this.socialItemDao.get(socialItemId), SocialItemDTO.class);
		// verifico si lo tiene equipado y si tiene lugar para pasarlo al
		// inventario
		if (socialItem.equals(playerDTO.getSocialParts().get(
				socialItem.getSlot()))
				&& this.roomOnInventory(playerDTO.getId())) {
			playerDTO.getSocialItems().add(socialItem);
			playerDTO.getSocialParts().put(socialItem.getSlot(), socialItem);
			Player player = mapper.map(playerDTO, Player.class);
			this.playerDao.update(player);
		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("equipado",
					"service.validation.player.does.not.have.item");
			throw new ValidationException(errorMap);
		}
	}

	public boolean roomOnInventory(Integer playerId) {
		PlayerDTO playerDTO = this.getPlayerById(playerId);

		return playerDTO.getSocialItems().size()
				+ playerDTO.getPhysicalItems().size() <= INVENTORY_SIZE;
	}

	public void addPointToPhysicalStat(Integer playerId,
			PhysicalStatDTO physicalStat, Integer amount)
			throws ValidationException {
		PlayerDTO playerDTO = this.getPlayerById(playerId);

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

			if (!sumo) {
				Map<String, String> errorMap = new HashMap<String, String>();
				errorMap.put("player",
						"service.validation.player.physical.stat.not.found");
				throw new ValidationException(errorMap);
			}

		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("player",
					"service.validation.player.physical.stat.not.enough.points");
			throw new ValidationException(errorMap);
		}
	}

	public void addPointToSocialStat(Integer playerId,
			PhysicalStatDTO socialStat, Integer amount)
			throws ValidationException {
		PlayerDTO playerDTO = this.getPlayerById(playerId);

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
			if (!sumo) {
				Map<String, String> errorMap = new HashMap<String, String>();
				errorMap.put("player",
						"service.validation.player.social.stat.not.found");
				throw new ValidationException(errorMap);
			}

		} else {
			Map<String, String> errorMap = new HashMap<String, String>();
			errorMap.put("player",
					"service.validation.player.social.stat.not.enough.points");
			throw new ValidationException(errorMap);
		}

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

	private void verifySocialStatAmount(
			Collection<SocialStatAmount> socialStatAmounts,
			Map<String, String> errors) {
		Integer acum = 0;
		for (SocialStatAmount socialStatAmount : socialStatAmounts) {
			acum = acum + socialStatAmount.getAmount();
		}
		if (acum != SOCIAL_STATS_AMOUNT) {
			errors.put("social",
					"service.validation.player.diferent.social.stats");
		}

	}

	private void verifyPhysicalStatAmount(
			Collection<PhysicalStatAmount> physicalStatAmounts,
			Map<String, String> errors) {
		Integer acum = 0;
		for (PhysicalStatAmount physicalStatAmount : physicalStatAmounts) {
			acum = acum + physicalStatAmount.getAmount();
		}
		if (acum != PHYSICAL_STATS_AMOUNT) {
			errors.put("social",
					"service.validation.player.diferent.physical.stats");
		}
	}

	@Required
	public void setPhysicalItemDao(PhysicalItemDao physicalItemDao) {
		this.physicalItemDao = physicalItemDao;
	}

	@Required
	public void setSocialItemDao(SocialItemDao socialItemDao) {
		this.socialItemDao = socialItemDao;
	}
}
