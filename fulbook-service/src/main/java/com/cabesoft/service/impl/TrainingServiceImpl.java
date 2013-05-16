package com.cabesoft.service.impl;

import com.cabesoft.model.dto.PhysicalEventDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialEventDTO;
import com.cabesoft.service.TrainingService;

public class TrainingServiceImpl implements TrainingService {

	public boolean executePhysicalEvent(PlayerDTO playerDTO,
			PhysicalEventDTO physicalEventDTO) {
		Integer requiredEnergy = this.calculateRequiredEnergy(playerDTO,
				physicalEventDTO);
		// primero verifico que el jugador cumpla con todas las condiciones
		// necesarias para realizar el entrenamiento
		// TODO Auto-generated method stub
		return false;

	}

	private Integer calculateRequiredEnergy(PlayerDTO playerDTO,
			PhysicalEventDTO physicalEventDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean executeSocialEvent(PlayerDTO player,
			SocialEventDTO socialEvent) {
		// TODO Auto-generated method stub
		return false;
	}

	public PlayerDTO findCompetitiveOponent(PlayerDTO player) {
		// TODO Auto-generated method stub
		return null;
	}

	public void executeCompetitiveTraining(PlayerDTO challenger,
			PlayerDTO challenge) {
		// TODO Auto-generated method stub

	}

}
