package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PositionDao;
import com.cabesoft.domain.model.Position;


public class PositionDaoImpl extends HibernateDaoSupport implements PositionDao  {

	public Serializable save(Position newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(Position instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Position instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Position get(Integer id) {
		return (Position) this.getHibernateTemplate().get(Position.class, id);
	}


}

