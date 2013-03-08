package com.cabesoft.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cabesoft.domain.enums.PlayerBehavior;

@Entity
@Table(name="Player")
public class Player {
	
	
	@Id
    @GeneratedValue
    private Long id;
    @Column(name="name")
    private String name;
    
    private List<PhysicalStatAmount> physicalStats;
    
    private List<SocialStatAmount> socialStats;
    
    private PlayerBehavior behavior;
    
    private Team team;
    
    private List<PlayerPosition> playerPosition;
    
    private Integer experience;
    
    private Integer level;
    
    private Integer physical_points;
    
    private Integer social_points;
    
	private Money money;
    
    private List<PlayerPhysicalItem> physicalItems;
    
    private List<PlayerSocialItem> socialItems;  
    
    private Integer physicalEnergy;
    
    private Integer socialEnergy;
    
    private Integer competitiveEnergy;
}
