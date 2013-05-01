package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PhysicalItemDao;
import com.cabesoft.domain.model.PhysicalItem;


public class PhysicalItemDaoImpl extends HibernateDaoSupport implements PhysicalItemDao  {

	public Serializable save(PhysicalItem newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(PhysicalItem instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(PhysicalItem instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public PhysicalItem get(Integer id) {
		return (PhysicalItem) this.getHibernateTemplate().get(PhysicalItem.class, id);
	}


}

