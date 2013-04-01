package com.cabesoft.domain.dao.test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.PlayerDao;
import com.cabesoft.domain.dao.impl.PhysicalStatDaoImpl;
import com.cabesoft.domain.dao.impl.SocialStatDaoImpl;
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.domain.utils.Money;



public class PlayerDaoImplTest  {
	
	public Player player;
	public ApplicationContext appContext;
	public PlayerDao playerDao;
	@Before
	public void setUp(){
		
		
		this.appContext = new ClassPathXmlApplicationContext("com/cabesoft/domain/dao/dao-context.xml");
		this.playerDao= (PlayerDao)appContext.getBean("playerDao");
		
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
		
		//
		Set<PhysicalStatAmount> physicalAmounts =new HashSet<PhysicalStatAmount>();
		physicalAmounts.add(new PhysicalStatAmount(physicalStat,1000));
		physicalAmounts.add(new PhysicalStatAmount(physicalStat2,2000));
		
		Set<SocialStatAmount> socialAmounts =new HashSet<SocialStatAmount>();
		socialAmounts.add(new SocialStatAmount(socialStat,1000));
		socialAmounts.add(new SocialStatAmount(socialStat2,2000));
		
		//genero el player con 	estas y lo persito
		this.player=new Player("Messi",  socialAmounts ,physicalAmounts);
		this.initializePlayer();
		
		
		
	}
	
	private void initializePlayer() {
		this.player.setAttackPoints(0);
		this.player.setAttackRankingPoints(0);
		this.player.setCompetitiveEnergy(3);
		this.player.setDefensePoints(0);
		this.player.setDefenseRankingPoints(0);
		this.player.setExpirience(0);
		this.player.setGoalKeeperPoints(0);
		this.player.setGoalKeeperRankingPoints(0);
		this.player.setLevel(1);
		Money money= new Money(2000,20);
		this.player.setMoney(money);
		this.player.setPhysicalEnergy(100);
		this.player.setSocialEnergy(3);
		
	}

	@Test 
	public void PersistAPlayerWithNoItems(){
		playerDao.save(this.player);
	}
}
