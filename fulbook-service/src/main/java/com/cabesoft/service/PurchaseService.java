package com.cabesoft.service;

import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;

public interface PurchaseService {

	boolean buyPhysicalItemWithFake(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO);

	boolean buyPhysicalItemWithToken(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO);

	boolean buySocialItemWithFake(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO);

	boolean buySocialItemWithToken(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO);

	boolean sellPhysicalItemFromInventory(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO);

	boolean sellPhysicalItemEquiped(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO);

	boolean sellSocialItemFromInventory(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO);

	boolean sellSocialItemEquiped(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO);
}
