package com.cabesoft.domain.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.model.SocialItem;


public class SocialItemDaoImpl 	extends HibernateDaoSupport {

		public void save(SocialItem si) {
			this.getHibernateTemplate().save(si);

		}
}

