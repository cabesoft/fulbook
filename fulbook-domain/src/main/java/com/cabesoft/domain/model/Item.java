package com.cabesoft.domain.model;

import javax.persistence.*;

public class Item {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Money price;
	
	private Integer requiredLevel;
	
	
	@Id
	@GeneratedValue
	@Column(name="oid")
	public Integer getId() {
		return id;
	}

	public Money getPrice() {
		return price;
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

	public void setPrice(Money price) {
		this.price = price;
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
