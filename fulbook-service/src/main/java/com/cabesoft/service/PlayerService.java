package com.cabesoft.service;

import java.util.Set;

import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.service.exception.ValidationException;

public interface PlayerService {

	PlayerDTO getPlayerById(Integer id);

	PlayerDTO getPlayerByName(String name);

	void createPlayer(String name, String face,
			Set<PhysicalStatAmount> physicalStatAmounts,
			Set<SocialStatAmount> socialStatAmount) throws ValidationException;

	boolean checkNameAvailable(String name);

	void addExpirience(Integer playerId, Integer amount)
			throws ValidationException;

	void equipPhysicalItem(Integer playerId, Integer physicalItemId)
			throws ValidationException;

	void equipSocialItem(Integer playerId, Integer socialItemId)
			throws ValidationException;

	void unEquipPhysicalItem(Integer playerId, Integer physicalItemId)
			throws ValidationException;

	void unEquipSocialItem(Integer playerId, Integer socialItemId)
			throws ValidationException;

	void addPointToPhysicalStat(Integer playerId, PhysicalStatDTO PhysicalStat,
			Integer amount) throws ValidationException;

	void addPointToSocialStat(Integer playerId, PhysicalStatDTO PhysicalStat,
			Integer amount) throws ValidationException;

	boolean roomOnInventory(Integer playerId);
}
