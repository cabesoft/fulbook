package com.cabesoft.domain.model;

public class PhysicalStatAmount {
	
	private PhysicalStat physicalStat;
	
	private Integer amount;

	public PhysicalStat getPhysicalStat() {
		return physicalStat;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setPhysicalStat(PhysicalStat physicalStat) {
		this.physicalStat = physicalStat;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
