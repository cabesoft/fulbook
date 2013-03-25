package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.TeamStat;


public class TeamStatDaoImpl extends HibernateDaoSupport {

		public void save(TeamStat ts) {
			this.getHibernateTemplate().save(ts);

		}
}