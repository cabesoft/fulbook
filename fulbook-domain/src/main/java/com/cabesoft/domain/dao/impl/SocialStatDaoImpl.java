package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.SocialStatDao;
import com.cabesoft.domain.model.SocialStat;


public class SocialStatDaoImpl extends HibernateDaoSupport implements SocialStatDao{

	public Serializable save(SocialStat newInstance) {
		return this.getHibernateTemplate().save(newInstance);

	}

	public void update(SocialStat instance) {
		this.getHibernateTemplate().update(instance);

	}

	public void remove(SocialStat instance) {
		this.getHibernateTemplate().delete(instance);

	}

	public SocialStat get(Integer id) {
		return (SocialStat) this.getHibernateTemplate().get(SocialStat.class, id);

	}


}