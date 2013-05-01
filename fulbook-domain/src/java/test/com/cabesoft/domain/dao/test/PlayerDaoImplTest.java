package com.cabesoft.domain.dao.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.PhysicalItemDao;
import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.dao.SocialItemDao;
import com.cabesoft.domain.dao.TeamDao;
import com.cabesoft.domain.dao.impl.PhysicalStatDaoImpl;
import com.cabesoft.domain.dao.impl.SocialStatDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.domain.model.PhysicalItemEquiped;
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialItem;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.domain.model.Team;
import com.cabesoft.domain.utils.Money;



public class PlayerDaoImplTest  {
	
	public static Player player;
	public static ApplicationContext appContext;
	public static PlayerDao playerDao;
	public static PhysicalItem physicalItem;
	public static Team team;
	
	@BeforeClass
	public static void setUp(){
		
		
		appContext = new ClassPathXmlApplicationContext("com/cabesoft/domain/dao/dao-context.xml");
		playerDao= (PlayerDao)appContext.getBean("playerDao");
		
		//genero las physical stats y las persisto
		PhysicalStatDaoImpl physicalStatDao=(PhysicalStatDaoImpl) appContext.getBean("physicalStatDao");
		PhysicalStat  physicalStat= new PhysicalStat();
		physicalStat.setName("destreza");
		PhysicalStat  physicalStat2= new PhysicalStat();
		physicalStat2.setName("fuerza");
		physicalStatDao.save(physicalStat);
		physicalStatDao.save(physicalStat2);

		
		//genero las social stats y las persisto
		SocialStatDaoImpl socialStatDao=(SocialStatDaoImpl) appContext.getBean("socialStatDao");
		SocialStat  socialStat= new SocialStat();
		socialStat.setName("descanso");
		SocialStat  socialStat2= new SocialStat();
		socialStat2.setName("alegria");
		socialStatDao.save(socialStat);
		socialStatDao.save(socialStat2);
		
		
		//genero el player lo persito
		Set<PhysicalStatAmount> physicalAmounts =new HashSet<PhysicalStatAmount>();
		physicalAmounts.add(new PhysicalStatAmount(physicalStat,1000));
		physicalAmounts.add(new PhysicalStatAmount(physicalStat2,2000));
		Set<SocialStatAmount> socialAmounts =new HashSet<SocialStatAmount>();
		socialAmounts.add(new SocialStatAmount(socialStat,1000));
		socialAmounts.add(new SocialStatAmount(socialStat2,2000));
		player=new Player("Messi",  socialAmounts ,physicalAmounts);
		initializePlayer(player);
		playerDao.save(player);
		
		
		//genero 1 item social
		SocialItemDao socialItemDao= (SocialItemDao)appContext.getBean("socialItemDao");
		SocialItem socialItem1= new SocialItem();
		socialItem1.setName("fiat 600");
		socialItem1.setPrice(new Money(6000,100));
		socialItem1.setRequiredLevel(5);
		socialItem1.setSlot(SocialSlot.CAR);
		socialItem1.setDescription("lala");
		Set<SocialStatAmount> socialStats= new HashSet<SocialStatAmount>();
		socialStats.add(new SocialStatAmount(socialStat,10));
		socialItem1.setStats(socialStats);
		socialItemDao.save(socialItem1);
		
		//genero un item fisico
		PhysicalItemDao physicalItemDao= (PhysicalItemDao)appContext.getBean("physicalItemDao");
		physicalItem= new PhysicalItem();
		physicalItem.setName("binchita piola");
		physicalItem.setPrice(new Money(1000,10));
		physicalItem.setRequiredLevel(2);
		physicalItem.setSlot(PhysicalSlot.HEAD);
		physicalItem.setDescription("con esta bincha tenes alta facha");
		Set<PhysicalStatAmount> physicalStats= new HashSet<PhysicalStatAmount>();
		physicalStats.add(new PhysicalStatAmount(physicalStat,10));
		physicalItem.setStats(physicalStats);
		physicalItemDao.save(physicalItem);
		
		//genero un equipo
		TeamDao teamDao= (TeamDao)appContext.getBean("teamDao");
		team= new Team();
		team.setName("farabute");
		team.setMoney(new Money(0,0));
		team.setLogo("url al logo");
		teamDao.save(team);
		
		
		
	}
	
	private static void initializePlayer(Player player) {
		player.setAttackPoints(0);
		player.setAttackRankingPoints(0);
		player.setCompetitiveEnergy(3);
		player.setDefensePoints(0);
		player.setDefenseRankingPoints(0);
		player.setExpirience(0);
		player.setGoalKeeperPoints(0);
		player.setGoalKeeperRankingPoints(0);
		player.setLevel(1);
		Money money= new Money(2000,20);
		player.setMoney(money);
		player.setPhysicalEnergy(100);
		player.setSocialEnergy(3);
		
	}

	@Test 
	public void updatePlayerWithAPhyisicalItem(){
		
	}
	
	@Test 
	public void genericTest(){
		Set<PhysicalItemEquiped> physicalStats= new HashSet<PhysicalItemEquiped>();
		physicalStats.add(new PhysicalItemEquiped(physicalItem,true));
		player.setPhysicalItems(physicalStats);
		player.setTeam(team);
		playerDao.update(player);

		playerDao.remove(player);
	}
	
}
