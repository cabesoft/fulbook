package com.cabesoft;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.impl.PhysicalStatDaoImpl;
import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.dao.impl.SocialStatDaoImpl;
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.service.PlayerService;

//import com.cabesoft.domain.dao.PlayerDAO;
//import com.cabesoft.domain.model.Player;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"com/cabesoft/service/applicationContext.xml");
		PhysicalStatDaoImpl physicalStatDaoImpl = (PhysicalStatDaoImpl) appContext
				.getBean("physicalStatDao");

		PhysicalStat physicalStat = new PhysicalStat();
		physicalStat.setName("destreza");
		physicalStatDaoImpl.save(physicalStat);

		physicalStatDaoImpl.save(physicalStat);

		PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount(
				physicalStat, 9);
		Set<PhysicalStatAmount> physicalItemStats = new HashSet<PhysicalStatAmount>();
		physicalItemStats.add(physicalStatAmount);

		// same for social

		SocialStatDaoImpl socialStatDaoImpl = (SocialStatDaoImpl) appContext
				.getBean("socialStatDao");

		SocialStat socialStat = new SocialStat();
		socialStat.setName("felicidad");
		socialStatDaoImpl.save(socialStat);

		socialStatDaoImpl.save(socialStat);

		SocialStatAmount socialStatAmount = new SocialStatAmount(socialStat, 9);
		Set<SocialStatAmount> socialItemStats = new HashSet<SocialStatAmount>();
		socialItemStats.add(socialStatAmount);

		PlayerDaoImpl playerDaoImpl = (PlayerDaoImpl) appContext
				.getBean("playerDao");
		Player player1 = new Player("messi", socialItemStats, physicalItemStats);
		playerDaoImpl.save(player1);

		PlayerService playerService = (PlayerService) appContext
				.getBean("playerService");

		PlayerDTO playerDTO = playerService.getPlayerByName("messi");
		// PhysicalStatDaoImpl physicalStatDaoImpl=
		// (PhysicalStatDaoImpl)appContext.getBean("physicalStatDao");
		//
		// //creo el item
		// PhysicalItem physicalItem = new PhysicalItem();
		// physicalItem.setDescription("pi");
		// physicalItem.setName("ojotas");
		// physicalItem.setRequiredLevel(1);
		// physicalItem.setSlot(PhysicalSlot.FEET);
		//
		//
		//
		// creo una stat
		// PhysicalStat physicalStat= new PhysicalStat();
		// physicalStat.setName("destreza");
		// physicalStatDaoImpl.save(physicalStat);
		//
		// //creo un physical stat amount y se lo agrego al item
		// PhysicalStatAmount physicalStatAmount= new PhysicalStatAmount();
		// physicalStatAmount.setStat(physicalStat);
		// physicalStatAmount.setAmount(9);
		// Set<PhysicalStatAmount> physicalItemStats= new
		// HashSet<PhysicalStatAmount>();
		// physicalItemStats.add(physicalStatAmount);
		// physicalItem.setStats(physicalItemStats);
		//
		// //persisto el item
		// PhysicalItemDaoImpl physicalItemDaoImpl=
		// (PhysicalItemDaoImpl)appContext.getBean("physicalItemDaoImpl");
		// physicalItemDaoImpl.save(physicalItem);
		//
		// creo el jugador y le asingo el item creado

		System.out.println("Done" + playerDTO);
	}
}
