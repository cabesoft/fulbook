package com.cabesoft.service.impl;

import org.springframework.beans.factory.annotation.Required;

import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
import com.cabesoft.service.PlayerService;
import com.cabesoft.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

	private PlayerService playerService;

	@Required
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public boolean buyPhysicalItemWithFake(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean buyPhysicalItemWithToken(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean buySocialItemWithFake(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean buySocialItemWithToken(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sellPhysicalItem(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sellSocialItem(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		// TODO Auto-generated method stub
		return false;
	}

}
