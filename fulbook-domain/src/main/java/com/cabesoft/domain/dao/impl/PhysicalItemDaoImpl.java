package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.PhysicalItem;


public class PhysicalItemDaoImpl extends HibernateDaoSupport {

		public void save(PhysicalItem pi) {
			this.getHibernateTemplate().save(pi);

		}
}

