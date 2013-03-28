package com.cabesoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.impl.PhysicalItemDaoImpl;
import com.cabesoft.domain.dao.impl.PhysicalStatDaoImpl;
import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.dao.impl.SocialItemDaoImpl;
import com.cabesoft.domain.dao.impl.SocialStatDaoImpl;
import com.cabesoft.domain.dao.impl.TeamItemDaoImpl;
import com.cabesoft.domain.dao.impl.TeamStatDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.TeamSlot;
import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialItem;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.TeamItem;
import com.cabesoft.domain.model.TeamStat;

//import com.cabesoft.domain.dao.PlayerDAO;
//import com.cabesoft.domain.model.Player;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    	    	  new ClassPathXmlApplicationContext("com/cabesoft/service/applicationContext.xml");
    	 
        		
    			PhysicalStatDaoImpl physicalStatDaoImpl= (PhysicalStatDaoImpl)appContext.getBean("physicalStatDao");
    	
    			//creo el item
    			PhysicalItem physicalItem = new PhysicalItem();
    			physicalItem.setDescription("pi");
    			physicalItem.setName("ojotas");
    			physicalItem.setRequiredLevel(1);
    			physicalItem.setSlot(PhysicalSlot.FEET);
    			
    			
    	    
    			//creo una stat
     			PhysicalStat physicalStat= new PhysicalStat();
     			physicalStat.setName("destreza");
     			physicalStatDaoImpl.save(physicalStat);
    			
    			//creo un physical stat amount y se lo agrego al item
    			PhysicalStatAmount physicalStatAmount= new PhysicalStatAmount();
    			physicalStatAmount.setStat(physicalStat);
    			physicalStatAmount.setAmount(9);
    			Set<PhysicalStatAmount> physicalItemStats= new HashSet<PhysicalStatAmount>();
    			physicalItemStats.add(physicalStatAmount);
    			physicalItem.setStats(physicalItemStats);
    			
    			
    	     	//creo el jugador y le asingo el item creado 
    			PlayerDaoImpl playerDaoImpl= (PlayerDaoImpl)appContext.getBean("playerDao");
    			Player player1= new Player();
    			player1.setName("Messi");
    			Set<PhysicalItem>  physicalItems= new HashSet<PhysicalItem>();
    			physicalItems.add(physicalItem);
    			player1.setPhysicalItems(physicalItems);
    			playerDaoImpl.save(player1);
    			

    	    	System.out.println("Done");
    }
}
