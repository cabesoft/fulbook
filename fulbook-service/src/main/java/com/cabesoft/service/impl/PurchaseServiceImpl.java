package com.cabesoft.service.impl;

import org.springframework.beans.factory.annotation.Required;

import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
import com.cabesoft.service.PlayerService;
import com.cabesoft.service.PurchaseService;

public class PurchaseServiceImpl implements PurchaseService {

	private static final Integer BUY_SELL_RELATION = null;
	private PlayerService playerService;

	public boolean buyPhysicalItemWithFake(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		boolean succes;
		Integer price = physicalItemDTO.getPrice().getFakeMoney();
		if (playerService.roomOnInventory(playerDTO)
				&& price < playerDTO.getMoney().getFakeMoney()) {
			succes = true;
			playerDTO.getPhysicalItems().add(physicalItemDTO);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() - price);
			playerService.update(playerDTO);
		} else {
			succes = false;
		}
		return succes;
	}

	public boolean buyPhysicalItemWithToken(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		boolean succes;
		Integer price = physicalItemDTO.getPrice().getTokenMoney();
		if (playerService.roomOnInventory(playerDTO)
				&& price < playerDTO.getMoney().getTokenMoney()) {
			succes = true;
			playerDTO.getPhysicalItems().add(physicalItemDTO);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getTokenMoney() - price);
			playerService.update(playerDTO);
		} else {
			succes = false;
		}
		return succes;
	}

	public boolean buySocialItemWithFake(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {

		boolean succes;
		Integer price = socialItemDTO.getPrice().getFakeMoney();
		if (playerService.roomOnInventory(playerDTO)
				&& price < playerDTO.getMoney().getFakeMoney()) {
			succes = true;
			playerDTO.getSocialItems().add(socialItemDTO);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() - price);
			playerService.update(playerDTO);
		} else {
			succes = false;
		}
		return succes;
	}

	public boolean buySocialItemWithToken(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		boolean succes;
		Integer price = socialItemDTO.getPrice().getTokenMoney();
		if (playerService.roomOnInventory(playerDTO)
				&& price < playerDTO.getMoney().getTokenMoney()) {
			succes = true;
			playerDTO.getSocialItems().add(socialItemDTO);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getTokenMoney() - price);
			playerService.update(playerDTO);
		} else {
			succes = false;
		}
		return succes;
	}

	public boolean sellPhysicalItemEquiped(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		boolean succes;
		if (playerDTO.getBodyParts().get(physicalItemDTO.getSlot())
				.equals(physicalItemDTO)) {
			succes = true;
			Integer sellPrice = (physicalItemDTO.getPrice().getFakeMoney() / BUY_SELL_RELATION);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() + sellPrice);
			playerDTO.getBodyParts().put(physicalItemDTO.getSlot(), null);
			this.playerService.update(playerDTO);

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean sellSocialItemFromInventory(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		boolean succes;
		if (playerDTO.getSocialItems().contains(socialItemDTO)) {
			succes = true;
			Integer sellPrice = (socialItemDTO.getPrice().getFakeMoney() / BUY_SELL_RELATION);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() + sellPrice);
			playerDTO.getSocialItems().remove(socialItemDTO);
			this.playerService.update(playerDTO);

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean sellSocialItemEquiped(PlayerDTO playerDTO,
			SocialItemDTO socialItemDTO) {
		boolean succes;
		if (playerDTO.getSocialParts().get(socialItemDTO.getSlot())
				.equals(socialItemDTO)) {
			succes = true;
			Integer sellPrice = (socialItemDTO.getPrice().getFakeMoney() / BUY_SELL_RELATION);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() + sellPrice);
			playerDTO.getSocialParts().put(socialItemDTO.getSlot(), null);
			this.playerService.update(playerDTO);

		} else {
			succes = false;
		}
		return succes;
	}

	public boolean sellPhysicalItemFromInventory(PlayerDTO playerDTO,
			PhysicalItemDTO physicalItemDTO) {
		boolean succes;
		if (playerDTO.getPhysicalItems().contains(physicalItemDTO)) {
			succes = true;
			Integer sellPrice = (physicalItemDTO.getPrice().getFakeMoney() / BUY_SELL_RELATION);
			playerDTO.getMoney().setFakeMoney(
					playerDTO.getMoney().getFakeMoney() + sellPrice);
			playerDTO.getPhysicalItems().remove(physicalItemDTO);
			this.playerService.update(playerDTO);

		} else {
			succes = false;
		}
		return succes;
	}

	@Required
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}
}
