package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.SocialItemDao;
import com.cabesoft.domain.model.SocialItem;


public class SocialItemDaoImpl 	extends HibernateDaoSupport implements SocialItemDao{

	public Serializable save(SocialItem newInstance) {
		return this.getHibernateTemplate().save(newInstance);		
	}

	public void update(SocialItem instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(SocialItem instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public SocialItem get(Integer id) {
		return (SocialItem) this.getHibernateTemplate().get(SocialItem.class, id);

	}


}

