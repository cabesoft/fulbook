package com.cabesoft.domain.model;

public class Item {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Money price;
	
	private Integer requiredLevel;
	
	public Integer getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(Integer requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public Integer getId() {
		return id;
	}

	public Money getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
	
	

}
