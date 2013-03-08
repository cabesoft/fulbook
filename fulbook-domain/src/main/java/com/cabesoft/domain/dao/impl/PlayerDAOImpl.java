package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PlayerDAO;
import com.cabesoft.domain.model.Player;

public class PlayerDAOImpl extends HibernateDaoSupport implements PlayerDAO {

	public void save(Player pl) {
		this.getHibernateTemplate().save(pl);

	}

}
