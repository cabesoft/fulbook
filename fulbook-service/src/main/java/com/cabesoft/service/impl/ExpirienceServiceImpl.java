package com.cabesoft.service.impl;

import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.service.ExpirienceService;

public class ExpirienceServiceImpl implements ExpirienceService{
	
	final int expirienceArray[]={1,2,4};
	public void addExpirienceToPlayer(PlayerDTO player, Integer expirience) {
	player.setExpirience(player.getExpirience()+expirience);
	int level=0;
	while(player.getExpirience()+expirience > expirienceArray[level]){
		level++;
	}
	player.setLevel(level);
	
	}
	
}
