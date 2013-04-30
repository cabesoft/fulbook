package com.cabesoft.model.dto;


public abstract class ItemDTO {
	private Integer id;

	private String name;

	private String description;

	private Integer requiredLevel;

	private MoneyDTO price;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(Integer requiredLevel) {
		this.requiredLevel = requiredLevel;
	}

	public MoneyDTO getPrice() {
		return price;
	}

	public void setPrice(MoneyDTO price) {
		this.price = price;
	}
}
