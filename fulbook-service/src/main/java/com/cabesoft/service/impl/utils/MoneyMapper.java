package com.cabesoft.service.impl.utils;

import com.cabesoft.domain.utils.Money;
import com.cabesoft.model.dto.MoneyDTO;

public class MoneyMapper {

	public Money toModel(MoneyDTO moneyDto) {
		return new Money(moneyDto.getFakeMoney(), moneyDto.getTokenMoney());
	}

	public MoneyDTO toDTO(Money money) {
		return new MoneyDTO(money.getFakeMoney(), money.getTokenMoney());
	}
}
