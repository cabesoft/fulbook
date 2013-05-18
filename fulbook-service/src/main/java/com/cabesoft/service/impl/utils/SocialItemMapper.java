package com.cabesoft.service.impl.utils;

import com.cabesoft.domain.model.SocialItem;
import com.cabesoft.model.dto.SocialItemDTO;

public class SocialItemMapper {

	private MoneyMapper moneyMapper;
	// TODO pasar esto a spring
	SocialStatAmountMapper socialStatAmountMapper = new SocialStatAmountMapper();

	public SocialItem toModel(SocialItemDTO socialItemDTO) {
		SocialItem socialItem = new SocialItem();
		socialItem.setDescription(socialItemDTO.getDescription());
		socialItem.setId(socialItemDTO.getId());
		socialItem.setName(socialItemDTO.getName());
		socialItem.setPrice(moneyMapper.toModel(socialItemDTO.getPrice()));
		socialItem.setRequiredLevel(socialItemDTO.getRequiredLevel());
		socialItem.setSlot(socialItemDTO.getSlot());
		socialItem.setStats(socialStatAmountMapper.toModel(socialItemDTO
				.getStats()));
		return socialItem;
	}

	public SocialItemDTO toDTO(SocialItem socialItem) {
		SocialItemDTO socialItemDTO = new SocialItemDTO();
		socialItemDTO.setDescription(socialItem.getDescription());
		socialItemDTO.setId(socialItem.getId());
		socialItemDTO.setName(socialItem.getName());
		socialItemDTO.setPrice(moneyMapper.toDTO(socialItem.getPrice()));
		socialItemDTO.setRequiredLevel(socialItem.getRequiredLevel());
		socialItemDTO.setSlot(socialItem.getSlot());
		socialItemDTO.setStats(socialStatAmountMapper.toDTO(socialItem
				.getStats()));
		return socialItemDTO;
	}
}
