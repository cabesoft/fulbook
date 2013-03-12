package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class League {
	
	@Id
    @GeneratedValue
    private Long id;
	
	private String name;
	
	private String description;
 
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
	private League parent;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "son_id", nullable = true)
	private League son;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league",
            fetch = FetchType.LAZY)
	private List<Team> teams;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league",
            fetch = FetchType.LAZY)
	private List<Match> matches;
	

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public League getParent() {
		return parent;
	}

	public League getSon() {
		return son;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParent(League parent) {
		this.parent = parent;
	}

	public void setSon(League son) {
		this.son = son;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	

}
