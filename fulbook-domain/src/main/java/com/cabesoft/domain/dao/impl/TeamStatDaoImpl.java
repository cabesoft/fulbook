package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.TeamStatDao;
import com.cabesoft.domain.model.TeamStat;


public class TeamStatDaoImpl extends HibernateDaoSupport implements  TeamStatDao{

	public Serializable save(TeamStat newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(TeamStat instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(TeamStat instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public TeamStat get(Integer id) {
		return (TeamStat) this.getHibernateTemplate().get(TeamStat.class, id);
	}

	

}