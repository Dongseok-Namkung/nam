package com.nkds.myapp.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanFactory implements ApplicationContextAware{
	private static ApplicationContext context;
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		// TODO Auto-generated method stub
		BeanFactory.context = context;
		
	}
	
	public static Object getBean(String sBeanName){
		System.out.println(sBeanName);
		return BeanFactory.context.getBean(sBeanName);
	}

}
