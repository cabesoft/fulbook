package com.cabesoft.service;

import java.util.Map;

import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;

public interface PlayerService {

	PlayerDTO getPlayerById(Integer id);

	PlayerDTO getPlayerByName(String name);

	PlayerDTO createPlayer(String name, String face,
			Map<PhysicalStat, Integer> physicalStatAmounts,
			Map<SocialStat, Integer> socialStatAmount);

	boolean checkNameAvailable(String name);

	void addExpirience(PlayerDTO player, Integer amount);

	boolean equipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean equipSocialItem(PlayerDTO player, SocialItemDTO socialItem);

	boolean unEquipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean unEquipSocialItem(PlayerDTO player, SocialItemDTO socialItem);

	boolean addPointToPhysicalStat(PlayerDTO playerDTO,
			PhysicalStat physicalStat, Integer amount);

	boolean addPointToSocialStat(PlayerDTO playerDTO, SocialStat socialStat,
			Integer amount);

	boolean roomOnInventory(PlayerDTO playerDTO);
}
