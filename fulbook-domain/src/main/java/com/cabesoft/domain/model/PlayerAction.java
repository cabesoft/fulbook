package com.cabesoft.domain.model;

public abstract class PlayerAction {

	private Integer levelRequired;
	
	public Integer getLevelRequired() {
		return levelRequired;
	}

	public void setLevelRequired(Integer levelRequired) {
		this.levelRequired = levelRequired;
	}
}
