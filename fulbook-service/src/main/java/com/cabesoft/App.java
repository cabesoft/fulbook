package com.cabesoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.impl.PhysicalItemDaoImpl;
import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.domain.model.PhysicalItemEquiped;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialItemEquiped;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.domain.utils.Money;

//import com.cabesoft.domain.dao.PlayerDAO;
//import com.cabesoft.domain.model.Player;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"com/cabesoft/service/applicationContext.xml");

		PlayerDaoImpl playerDao = (PlayerDaoImpl) appContext
				.getBean("playerDao");

		PhysicalItemDaoImpl physicalItemDaoImpl = (PhysicalItemDaoImpl) appContext
				.getBean("physicalItemDao");

		Player messi = createMessi(playerDao);

		PhysicalItemEquiped physicalItemEquiped = createPhysicalItemEquiped(physicalItemDaoImpl);

		messi.getPhysicalItems().add(physicalItemEquiped);

		playerDao.update(messi);

		Player messiZombie = playerDao.getPlayerByName("messi");
		PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount(
				PhysicalStat.STRENGTH, 40);
		HashSet<PhysicalStatAmount> physicalStatAmounts = new HashSet<PhysicalStatAmount>();
		physicalStatAmounts.add(physicalStatAmount);
		playerDao.update(messiZombie);

		System.out.println("Done" + messiZombie);

	}

	private static Player createMessi(PlayerDaoImpl playerDao) {
		Player player = new Player();
		player.setName("messi");
		player.setFace("1");
		player.setAttackPoints(0);
		player.setAttackRankingPoints(0);
		player.setGoalKeeperPoints(0);
		player.setGoalKeeperRankingPoints(0);
		player.setDefensePoints(0);
		player.setDefenseRankingPoints(0);
		player.setLevel(1);
		player.setExpirience(0);
		player.setPhysicalEnergy(100);
		player.setSocialEnergy(3);
		player.setCompetitiveEnergy(2);
		player.setMoney((new Money(100, 5)));
		player.setPhysicalItems(new ArrayList<PhysicalItemEquiped>());
		player.setSocialItems(new ArrayList<SocialItemEquiped>());

		PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount(
				PhysicalStat.REFLEXES, 100);
		HashSet<PhysicalStatAmount> physicalStatAmounts = new HashSet<PhysicalStatAmount>();
		physicalStatAmounts.add(physicalStatAmount);
		player.setPhysicalStatAmounts(physicalStatAmounts);

		player.setSocialStatAmounts(new HashSet<SocialStatAmount>());

		playerDao.save(player);
		return player;
	}

	private static PhysicalItemEquiped createPhysicalItemEquiped(
			PhysicalItemDaoImpl physicalItemDaoImpl) {
		PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount();
		physicalStatAmount.setAmount(5);
		physicalStatAmount.setStat(PhysicalStat.DRIBLING);
		Set<PhysicalStatAmount> stats = new HashSet<PhysicalStatAmount>();
		stats.add(physicalStatAmount);

		PhysicalItem physicalItem = new PhysicalItem();
		physicalItem.setId(1);
		physicalItem.setSlot(PhysicalSlot.HEAD);
		physicalItem.setName("Gorra");
		physicalItem.setDescription("gorra pedorra");
		physicalItem.setPrice(new Money(10, 1));
		physicalItem.setRequiredLevel(1);
		physicalItem.setStats(stats);
		physicalItemDaoImpl.save(physicalItem);

		PhysicalItemEquiped physicalItemEquiped = new PhysicalItemEquiped();
		physicalItemEquiped.setEquiped(true);
		physicalItemEquiped.setId(1);
		physicalItemEquiped.setPhysicalItem(physicalItem);
		return physicalItemEquiped;
	}
}
