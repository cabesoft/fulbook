package com.cabesoft.service;

import java.util.Collection;

import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;

public interface PlayerService {

	PlayerDTO getPlayerById(Integer id);

	PlayerDTO getPlayerByName(String name);

	PlayerDTO createPlayer(String name, String face,
			Collection<PhysicalStatAmount> physicalStatAmounts,
			Collection<SocialStatAmount> socialStatAmount);

	boolean checkNameAvailable(String name);

	void addExpirience(PlayerDTO player, Integer amount);

	boolean equipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean equipSocialItem(PlayerDTO player, SocialItemDTO physicalItem);

	boolean unEquipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean unEquipSocialItem(PlayerDTO player, SocialItemDTO physicalItem);

	boolean addPointToPhysicalStat(PlayerDTO challenger,
			PhysicalStatDTO PhysicalStat);

}
