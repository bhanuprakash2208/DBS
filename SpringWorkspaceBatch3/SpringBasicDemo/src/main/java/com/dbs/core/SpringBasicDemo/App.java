package com.dbs.core.SpringBasicDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dbs.core.SpringBasicDemo.model.CollDemo;
import com.dbs.core.SpringBasicDemo.model.Invoices;
import com.dbs.core.SpringBasicDemo.model.Product;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    	System.out.println("Loaded");
		
		  Product p1 = (Product)context.getBean("p1"); System.out.println(p1);
		  //#{T(java.time.LocalDate).now()} 
		  Invoices inv =(Invoices)context.getBean("inv1");
		  inv.setInvoiceamount(inv.getProduct().getPrice()*inv.getQty());
		  System.out.println(inv);
		  
		  CollDemo c1 = context.getBean(CollDemo.class);
		  
		  System.out.println(c1.getFruits()); System.out.println(c1.getCertificates());
		  System.out.println(c1.getMap()); System.out.println(c1.getProducts());
		 
		/*
		 * Invoices inv = context.getBean(Invoices.class); System.out.println(inv);
		 */
    	
    }
}
