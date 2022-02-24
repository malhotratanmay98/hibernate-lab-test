package com.web.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbDriverListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		
		System.out.println("---------------------Driver is Loaded--------------------");
		
		String driverName=sce.getServletContext().getInitParameter("driver");
		try {
			Class.forName(driverName);
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

}