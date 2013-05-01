package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.TeamDao;
import com.cabesoft.domain.model.Team;


public class TeamDaoImpl extends HibernateDaoSupport implements TeamDao  {

	public Serializable save(Team newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(Team instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Team instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Team get(Integer id) {
		return (Team) this.getHibernateTemplate().get(Team.class, id);
	}


}

