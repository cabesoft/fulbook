package com.cabesoft.service;

import com.cabesoft.model.dto.PhysicalEventDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialEventDTO;

public interface TrainingService {
	
	boolean executePhysicalEvent(PlayerDTO player,
			PhysicalEventDTO physicalEvent);

	boolean executeSocialEvent(PlayerDTO player, SocialEventDTO socialEvent);

	PlayerDTO findCompetitiveOponent(PlayerDTO player);

	void executeCompetitiveTraining(PlayerDTO challenger, PlayerDTO challenge);
}
