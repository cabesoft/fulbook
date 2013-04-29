package com.cabesoft.model.dto;

public class EventDTO {
	private Integer id;
	private String name;
	private String description;
	private Integer level;
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getLevel() {
		return level;
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
	public void setLevel(Integer level) {
		this.level = level;
	}
}
