package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PhysicalStatDao;
import com.cabesoft.domain.enums.PhysicalStat;


public class PhysicalStatDaoImpl extends HibernateDaoSupport implements PhysicalStatDao{

	public Serializable save(PhysicalStat newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(PhysicalStat instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(PhysicalStat instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public PhysicalStat get(Integer id) {
		return (PhysicalStat) this.getHibernateTemplate().get(PhysicalStat.class, id);
	}


}

