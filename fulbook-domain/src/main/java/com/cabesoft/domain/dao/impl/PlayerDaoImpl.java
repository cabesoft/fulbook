package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.Player;

public class PlayerDaoImpl extends HibernateDaoSupport{
	public void save(Player player) {
		this.getHibernateTemplate().save(player);

	}
}

