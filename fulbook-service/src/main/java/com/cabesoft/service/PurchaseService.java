package com.cabesoft.service;

import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;

public interface PurchaseService {

	boolean buyPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean buySocialItem(PlayerDTO player, SocialItemDTO socialItem);

	boolean sellPhysicalItem(PlayerDTO player, PhysicalItemDTO physicalItem);

	boolean sellSocialItem(PlayerDTO player, SocialItemDTO socialItem);
}
