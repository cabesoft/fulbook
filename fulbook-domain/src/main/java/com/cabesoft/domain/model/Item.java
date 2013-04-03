package com.cabesoft.domain.model;

import javax.persistence.*;

import com.cabesoft.domain.utils.Money;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private Integer requiredLevel;
	
	private Money price;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="oid")
	public Integer getId() {
		return id;
	}


	@Column(name="name", nullable= false)
	public String getName() {
		return name;
	}
	@Column(name="description", nullable= false)
	public String getDescription() {
		return description;
	}
	@Column(name="required_level", nullable= false)
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

	@Embedded
	public Money getPrice() {
		return price;
	}


	public void setPrice(Money price) {
		this.price = price;
	}

}
