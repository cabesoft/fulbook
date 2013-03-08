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
    
    
    
}
