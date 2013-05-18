package com.cabesoft.service.impl.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;

public class SocialStatAmountMapper {

	public Map<SocialStat, Integer> toDTO(
			Set<SocialStatAmount> socialStatsAmounts) {
		Map<SocialStat, Integer> map = new HashMap<SocialStat, Integer>();
		for (SocialStatAmount socialStatAmount : socialStatsAmounts) {
			// TODO aca se podria verificar que no vuelva a meter la misma key
			map.put(socialStatAmount.getStat(), socialStatAmount.getAmount());

		}
		return map;
	}

	public Set<SocialStatAmount> toModel(Map<SocialStat, Integer> map) {
		Set<SocialStatAmount> list = new HashSet<SocialStatAmount>();
		Set<Entry<SocialStat, Integer>> entrySet = map.entrySet();
		for (Entry<SocialStat, Integer> entry : entrySet) {
			SocialStatAmount socialStatAmount = new SocialStatAmount();
			socialStatAmount.setStat(entry.getKey());
			socialStatAmount.setAmount(entry.getValue());
			list.add(socialStatAmount);
		}
		return list;
	}
}
