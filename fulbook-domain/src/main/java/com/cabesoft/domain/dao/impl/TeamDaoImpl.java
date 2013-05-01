package com.cabesoft.domain.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cabesoft.domain.dao.TeamDao;
import com.cabesoft.domain.model.Team;

public class TeamDaoImpl extends HibernateDaoSupport implements TeamDao {

	public Serializable save(Team newInstance) {
		return this.getHibernateTemplate().save(newInstance);
	}

	public void update(Team instance) {
		this.getHibernateTemplate().update(instance);
	}

	public void remove(Team instance) {
		this.getHibernateTemplate().delete(instance);
	}

	public Team get(Integer id) {
		return (Team) this.getHibernateTemplate().get(Team.class, id);
	}

	@SuppressWarnings("unchecked")
	public Team getTeamByName(String name) {
		Criteria criteria = this.getSession(false).createCriteria(Team.class);
		criteria.add(Restrictions.eq("name", name));
		List<Team> teams = criteria.list();
		if (teams.size() == 1) {
			return teams.get(0);
		} else {
			if (teams.size() > 1) {
				// TODO: crear una excepcion para esto!
				throw new RuntimeException(
						"More than one team with same name: " + name);
			}
		}

		return null;
	}

	public void deactivateTeam(Integer teamId) {
		Criteria criteria = this.getSession(false).createCriteria(Team.class);
		criteria.
		
	}
}
