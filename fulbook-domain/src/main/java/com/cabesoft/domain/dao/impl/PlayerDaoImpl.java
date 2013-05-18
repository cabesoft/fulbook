package com.cabesoft.domain.dao.impl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.model.Player;

public class PlayerDaoImpl extends HibernateDaoSupport implements PlayerDao {

	private static final String FIND_BY_NAME_QUERY = "from Player where name= :name";
	private Session session = this.getSession();
	public Serializable save(Player newInstance) {


		Transaction beginTransaction = session.beginTransaction();
		Serializable ser= this.getHibernateTemplate().save(newInstance);
		beginTransaction.commit();
		this.session.flush();
		return ser;
	}

	public void update(Player instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Player instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Player get(Integer id) {
		return (Player) this.getHibernateTemplate().get(Player.class, id);
	}

	public Player getPlayerByName(String name) {
		
		Transaction beginTransaction = session.beginTransaction();
		Query query = session.createQuery(FIND_BY_NAME_QUERY);
		query.setParameter("name", name);
		Player player = (Player) query.uniqueResult();
		beginTransaction.commit();
		session.flush();
		return player;
	}

}
