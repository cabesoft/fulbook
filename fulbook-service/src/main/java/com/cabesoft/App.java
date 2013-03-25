package com.cabesoft;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.impl.PhysicalItemDaoImpl;
import com.cabesoft.domain.dao.impl.PhysicalStatDaoImpl;
import com.cabesoft.domain.dao.impl.SocialItemDaoImpl;
import com.cabesoft.domain.dao.impl.SocialStatDaoImpl;
import com.cabesoft.domain.dao.impl.TeamItemDaoImpl;
import com.cabesoft.domain.dao.impl.TeamStatDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.TeamSlot;
import com.cabesoft.domain.model.PhysicalItem;
import com.cabesoft.domain.model.PhysicalItemStat;
import com.cabesoft.domain.model.PhysicalStat;
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
    	 
    
    			
    			PhysicalItemDaoImpl pdao= (PhysicalItemDaoImpl)appContext.getBean("physicalItemDao");
    	    	
    			/** insert **/
    			
    			PhysicalItem pi = new PhysicalItem();
    			pi.setDescription("pi");
    			pi.setName("ojotas");
    			pi.setRequiredLevel(1);
    			pi.setSlot(PhysicalSlot.FEET);
    			
    			PhysicalStatDaoImpl psdao= (PhysicalStatDaoImpl)appContext.getBean("physicalStatDao");
    	    	
    			/** insert **/
    			
     			PhysicalStat physicalStat2= new PhysicalStat();
     			physicalStat2.setName("destreza");
    			psdao.save(physicalStat2);
    			
    			
    			PhysicalItemStat physicalItemStat= new PhysicalItemStat();
    			physicalItemStat.setItem(pi);
    			physicalItemStat.setStat(physicalStat2);
    			physicalItemStat.setAmount(9);
    			
    			Set<PhysicalItemStat> physicalItemStats= new HashSet<PhysicalItemStat>();
    			physicalItemStats.add(physicalItemStat);
    			pi.setStats(physicalItemStats);
    			pdao.save(pi);
    			
    	     	 
    	    	System.out.println("Done");
    }
}
