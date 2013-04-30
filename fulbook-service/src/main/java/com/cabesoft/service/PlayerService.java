package com.cabesoft.service;

import java.util.Collection;

import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PhysicalEventDTO;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialEventDTO;
import com.cabesoft.model.dto.SocialItemDTO;

public interface PlayerService {

	PlayerDTO getPlayerByName(String name);

	boolean createPlayer(String name, String face,
			Collection<PhysicalStatAmount> physicalStatAmounts,
			Collection<SocialStatAmount> socialStatAmount);

	boolean checkNameAvailable(String name);

	void addExpirience(PlayerDTO player, Integer amount);

	boolean buyPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean buySocialItem(PlayerDTO player, SocialItemDTO socialItem);

	boolean executePhysicalEvent(PlayerDTO player,
			PhysicalEventDTO physicalEvent);

	boolean executeSocialEvent(PlayerDTO player, SocialEventDTO socialEvent);

	boolean equipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean equipSocialItem(PlayerDTO player, SocialItemDTO physicalItem);

	boolean unEquipPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean unEquipSocialItem(PlayerDTO player, SocialItemDTO physicalItem);

	PlayerDTO findCompetitiveOponent(PlayerDTO player);

	void executeCompetitiveTraining(PlayerDTO challenger, PlayerDTO challenge);

	boolean addPointToPhysicalStat(PlayerDTO challenger,
			PhysicalStatDTO PhysicalStat);

	boolean sellPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean sellSocialItem(PlayerDTO player, SocialItemDTO socialItem);

}
