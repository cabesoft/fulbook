package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.TeamItemDao;
import com.cabesoft.domain.model.TeamItem;


public class TeamItemDaoImpl extends HibernateDaoSupport implements TeamItemDao{

	public Serializable save(TeamItem newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(TeamItem instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(TeamItem instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public TeamItem get(Integer id) {
		return (TeamItem) this.getHibernateTemplate().get(TeamItem.class, id);
	}

		
}

