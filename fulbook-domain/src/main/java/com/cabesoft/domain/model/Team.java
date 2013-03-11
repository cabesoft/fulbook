package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Team")
public class Team {
	@Id
    @GeneratedValue
    private Long id;
     
    @Column(name="name")
    private String name;
    
    private List<Player> players;

    private Money money;
 
    private List<TeamItem> items;
    
    private League league;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Money getMoney() {
		return money;
	}

	public void setMoney(Money money) {
		this.money = money;
	}

	public List<TeamItem> getItems() {
		return items;
	}

	public void setItems(List<TeamItem> items) {
		this.items = items;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
    
    
    
}
