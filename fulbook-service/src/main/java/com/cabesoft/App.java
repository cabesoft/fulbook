package com.cabesoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabesoft.domain.dao.PlayerDAO;
import com.cabesoft.domain.model.Player;

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
    	 
    			PlayerDAO dao= (PlayerDAO)appContext.getBean("playerDAO");
    	
    			/** insert **/
    	    	Player pl = new Player();
    	    	pl.setName("jp");
    	    	dao.save(pl);
    	     	 
    	    	System.out.println("Done");
    }
}
