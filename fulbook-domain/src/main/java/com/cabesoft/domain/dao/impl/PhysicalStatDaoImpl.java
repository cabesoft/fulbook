package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.PhysicalStat;


public class PhysicalStatDaoImpl extends HibernateDaoSupport {

		public void save(PhysicalStat ps) {
			this.getHibernateTemplate().save(ps);

		}
}

