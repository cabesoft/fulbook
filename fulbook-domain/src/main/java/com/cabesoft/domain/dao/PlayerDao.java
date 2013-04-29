package com.cabesoft.domain.dao;

import com.cabesoft.domain.model.Player;

public interface PlayerDao extends GenericDao<Player> {

	Player getPlayerByName(String name);

}
