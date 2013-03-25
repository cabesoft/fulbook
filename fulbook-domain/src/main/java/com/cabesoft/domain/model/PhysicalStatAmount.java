package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PhysicalStatAmount {
	@Id
    @GeneratedValue
	private Integer id;
	private String name;
	private Integer amount;
	
	

	public PhysicalStatAmount(String name, Integer amount) {
		this.name=name;
		this.amount=amount;
	}
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
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
