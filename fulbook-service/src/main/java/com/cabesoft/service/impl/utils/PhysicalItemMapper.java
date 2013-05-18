package com.cabesoft.service.impl.utils;

import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.model.dto.PhysicalItemDTO;

public class PhysicalItemMapper {

	private MoneyMapper moneyMapper;
	// TODO pasar esto a spring
	PhysicalStatAmountMapper physicalStatAmountMapper = new PhysicalStatAmountMapper();

	public PhysicalItem toModel(PhysicalItemDTO physicalItemDTO) {
		PhysicalItem physicalItem = new PhysicalItem();
		physicalItem.setDescription(physicalItemDTO.getDescription());
		physicalItem.setId(physicalItemDTO.getId());
		physicalItem.setName(physicalItemDTO.getName());
		physicalItem.setPrice(moneyMapper.toModel(physicalItemDTO.getPrice()));
		physicalItem.setRequiredLevel(physicalItemDTO.getRequiredLevel());
		physicalItem.setSlot(physicalItemDTO.getSlot());
		physicalItem.setStats(physicalStatAmountMapper.toModel(physicalItemDTO
				.getStats()));
		return physicalItem;
	}

	public PhysicalItemDTO toDTO(PhysicalItem physicalItem) {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		physicalItemDTO.setDescription(physicalItem.getDescription());
		physicalItemDTO.setId(physicalItem.getId());
		physicalItemDTO.setName(physicalItem.getName());
		physicalItemDTO.setPrice(moneyMapper.toDTO(physicalItem.getPrice()));
		physicalItemDTO.setRequiredLevel(physicalItem.getRequiredLevel());
		physicalItemDTO.setSlot(physicalItem.getSlot());
		physicalItemDTO.setStats(physicalStatAmountMapper.toDTO(physicalItem
				.getStats()));
		return physicalItemDTO;
	}
}
