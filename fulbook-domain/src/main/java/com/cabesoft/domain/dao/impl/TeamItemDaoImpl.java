package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.TeamItem;


public class TeamItemDaoImpl extends HibernateDaoSupport {

		public void save(TeamItem ti) {
			this.getHibernateTemplate().save(ti);

		}
}

