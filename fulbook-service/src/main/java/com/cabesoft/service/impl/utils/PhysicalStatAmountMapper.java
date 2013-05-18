package com.cabesoft.service.impl.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;

public class PhysicalStatAmountMapper {

	public Map<PhysicalStat, Integer> toDTO(
			Set<PhysicalStatAmount> physicalStatsAmounts) {
		Map<PhysicalStat, Integer> map = new HashMap<PhysicalStat, Integer>();
		for (PhysicalStatAmount physicalStatAmount : physicalStatsAmounts) {
			// TODO aca se podria verificar que no vuelva a meter la misma key
			map.put(physicalStatAmount.getStat(),
					physicalStatAmount.getAmount());

		}
		return map;
	}

	public Set<PhysicalStatAmount> toModel(Map<PhysicalStat, Integer> map) {
		Set<PhysicalStatAmount> list = new HashSet<PhysicalStatAmount>();
		Set<Entry<PhysicalStat, Integer>> entrySet = map.entrySet();
		for (Entry<PhysicalStat, Integer> entry : entrySet) {
			PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount();
			physicalStatAmount.setStat(entry.getKey());
			physicalStatAmount.setAmount(entry.getValue());
			list.add(physicalStatAmount);
		}
		return list;
	}
}
