package com.cabesoft.domain.model.utils;

import java.io.Serializable;

import javax.persistence.ManyToOne;
import com.cabesoft.domain.model.SocialItem;
import com.cabesoft.domain.model.SocialStat;

public class ItemSocialStatPK implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
	private SocialItem item;
	@ManyToOne
	private SocialStat socialStat;
	
	public ItemSocialStatPK(){
		
	}

	public SocialItem getItem() {
		return item;
	}

	public void setItem(SocialItem item) {
		this.item = item;
	}

	public SocialStat getSocialStat() {
		return socialStat;
	}

	public void setSocialStat(SocialStat socialStat) {
		this.socialStat = socialStat;
	}

	
}
