package com.cabesoft;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.service.impl.PlayerServiceImpl;

//import com.cabesoft.domain.dao.PlayerDAO;
//import com.cabesoft.domain.model.Player;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"com/cabesoft/service/applicationContext.xml");

		Mapper mapper = new DozerBeanMapper();
		PlayerDaoImpl playerDao = (PlayerDaoImpl) appContext
				.getBean("playerDao");
		PlayerServiceImpl playerService = new PlayerServiceImpl();
		playerService.setMapper(mapper);
		playerService.setPlayerDao(playerDao);

		Map<PhysicalStat, Integer> physicalStats = new HashMap<PhysicalStat, Integer>();
		physicalStats.put(PhysicalStat.STRENGTH, 20);

		// same for social

		Map<SocialStat, Integer> socialStats = new HashMap<SocialStat, Integer>();
		socialStats.put(SocialStat.HAPPINESS, 5);

		playerService.createPlayer("messi", "cara de mongo", physicalStats,
				socialStats);
		System.out.println("Done");

	}

}
