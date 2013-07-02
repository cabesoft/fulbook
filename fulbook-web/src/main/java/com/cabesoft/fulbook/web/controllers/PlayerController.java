package com.cabesoft.fulbook.web.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cabesoft.fulbook.web.requests.DTO.CreatePlayerDTO;
import com.cabesoft.fulbook.web.requests.DTO.EquipPhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.service.PlayerService;
import com.cabesoft.service.exception.ValidationException;

@Controller
@RequestMapping("/player")
public class PlayerController {
	private PlayerService playerService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	private void test(HttpServletRequest request) {
		System.out.print(request);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	private @ResponseBody
	boolean test(@PathVariable("name") String name, HttpServletRequest request) {
		return this.playerService.getPlayerByName(name) == null;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(@RequestBody CreatePlayerDTO createDto,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("fulbook-json");
		try {
			this.playerService.createPlayer(createDto.getName(),
					createDto.getFace(), createDto.getPhysicalStats(),
					createDto.getSocialStats());
		} catch (ValidationException e) {
			this.extractError(modelAndView, e);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/physical/equip/", method = RequestMethod.POST)
	public ModelAndView equipPhysicalItem(@RequestBody EquipPhysicalItemDTO	equipPhysicalItemDTO,HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("fulbook-json");
		try {
			
			this.playerService.equipPhysicalItem(equipPhysicalItemDTO.getPlayerId(), equipPhysicalItemDTO.getPhysicalItemId()) ;
		} catch (ValidationException e) {
			this.extractError(modelAndView, e);
		}
		return modelAndView;
	}	

	@Required
	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	private void extractError(ModelAndView mav, ValidationException e) {
		Map<String, String> map = new HashMap<String, String>();

		for (String error : e.getErrors().keySet()) {
			// key es el campo, value es el mensaje
			map.put(error, e.getErrors().get(error));
		}

		mav.addObject("errors", map);
	}
}
