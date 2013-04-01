package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.model.Player;

public class PlayerDaoImpl extends HibernateDaoSupport implements PlayerDao{
	
	public Serializable save(Player newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}
	
	public void update(Player instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Player instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Player get(Integer id) {
		return (Player) this.getHibernateTemplate().get(Player.class, id);
	}


	
	
}

