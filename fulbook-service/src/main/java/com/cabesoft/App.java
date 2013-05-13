package com.cabesoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.cabesoft.domain.dao.PlayerDAO;
//import com.cabesoft.domain.model.Player;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"com/cabesoft/service/applicationContext.xml");

		System.out.println("Done");
	}
}
