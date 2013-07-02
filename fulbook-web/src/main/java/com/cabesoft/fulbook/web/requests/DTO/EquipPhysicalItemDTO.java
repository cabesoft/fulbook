package com.cabesoft.fulbook.web.requests.DTO;

/**
 * @author Santi
 *
 */
public class EquipPhysicalItemDTO {
	private  Integer playerId;
	private Integer physicalItemId;
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public Integer getPhysicalItemId() {
		return physicalItemId;
	}
	public void setPhysicalItemId(Integer physicalItemId) {
		this.physicalItemId = physicalItemId;
	}
	
}
