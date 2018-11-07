package com.univ.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * @author: liuml
 * @date: 2015年7月26日 下午8:35:48 
 * @version: 1.0 
 * @description: 用来比较其和struts2的拦截器的初始化顺序，经验证，监听器的初始化在前
 */

public class MyListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyListener contextInitialized");

	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyListener contextDestroyed");
	}
	
	public MyListener(){
		System.out.println("MyListener()");
	}

}


