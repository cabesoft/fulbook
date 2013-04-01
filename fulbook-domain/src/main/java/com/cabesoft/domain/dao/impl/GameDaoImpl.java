package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.GameDao;
import com.cabesoft.domain.model.Game;


public class GameDaoImpl extends HibernateDaoSupport implements GameDao  {

	public Serializable save(Game newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(Game instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Game instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Game get(Integer id) {
		return (Game) this.getHibernateTemplate().get(Game.class, id);
	}


}

