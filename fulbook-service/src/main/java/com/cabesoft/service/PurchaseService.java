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

	boolean sellPhysicalItem(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO);

	boolean sellSocialItem(PlayerDTO playerDTO, SocialItemDTO socialItemDTO);
}
