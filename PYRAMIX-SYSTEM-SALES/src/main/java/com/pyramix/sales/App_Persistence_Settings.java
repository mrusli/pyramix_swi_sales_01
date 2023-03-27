package com.pyramix.sales;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pyramix.domain.user.User;
import com.pyramix.persistence.user.dao.UserDao;

public class App_Persistence_Settings {

	private static final Logger log = Logger.getLogger(App_Persistence_Settings.class);
	
	private static ApplicationContext ctx;
	
	public static void main(String[] args) throws Exception {
		log.info("Hello World!!!");
		
		 ctx = new ClassPathXmlApplicationContext("CommonContext-Dao.xml");

		 UserDao userDao = (UserDao) ctx.getBean("userDao");
		 User selUser = userDao.findUserById(1L);
		 
		 log.info(selUser.toString());
		 
		 selUser = userDao.findUserByUsername("rusli");
		 
		 log.info(selUser.toString());
	}

}
