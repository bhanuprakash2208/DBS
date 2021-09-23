package com.dbs.core.SpringBasicDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.dbs.core.SpringBasicDemo.model.Guitar;
import com.dbs.core.SpringBasicDemo.model.Invoices;
import com.dbs.core.SpringBasicDemo.model.Singer;

@Configuration
//@ComponentScan
@ComponentScan(basePackages = {"demo","com.dbs.core.SpringBasicDemo"})
public class AppConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Loaded without any xml");
		/*
		 * Invoices inv = context.getBean(Invoices.class); System.out.println(inv);
		 * 
		 * //Beans that are created String [] beans = context.getBeanDefinitionNames();
		 * for(String bean : beans) System.out.println(bean);
		 */
        
        Singer sing = context.getBean(Singer.class);
    	System.out.println(sing);
	}

}
