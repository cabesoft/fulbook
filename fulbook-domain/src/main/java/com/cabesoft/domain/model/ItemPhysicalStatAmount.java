package com.cabesoft.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.model.utils.ItemPhysicalStatPK;

@Entity
@IdClass(ItemPhysicalStatPK.class)
public class ItemPhysicalStatAmount {
		@Id
		private PhysicalItem item;
		@Id
		private PhysicalStat physicalStat;
		
		private Integer amount;
		

		public PhysicalItem getItem() {
			return item;
		}
		public void setItem(PhysicalItem item) {
			this.item = item;
		}
		public PhysicalStat getPhysicalStat() {
			return physicalStat;
		}
		public void setPhysicalStat(PhysicalStat physicalStat) {
			this.physicalStat = physicalStat;
		}
		public Integer getAmount() {
			return amount;
		}
		public void setAmount(Integer amount) {
			this.amount = amount;
		}
}
