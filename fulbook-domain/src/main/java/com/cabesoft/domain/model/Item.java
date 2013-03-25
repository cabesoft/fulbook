package com.cabesoft.domain.model;

import javax.persistence.*;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Integer requiredLevel;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="oid")
	public Integer getId() {
		return id;
	}


	@Column(name="name")
	public String getName() {
		return name;
	}
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	@Column(name="required_level")
	public Integer getRequiredLevel() {
		return requiredLevel;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
		
	public void setRequiredLevel(Integer requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

}
