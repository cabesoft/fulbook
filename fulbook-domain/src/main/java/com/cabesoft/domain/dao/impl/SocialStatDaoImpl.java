package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.SocialStat;


public class SocialStatDaoImpl extends HibernateDaoSupport {

		public void save(SocialStat ss) {
			this.getHibernateTemplate().save(ss);

		}
}