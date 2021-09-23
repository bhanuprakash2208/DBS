package com.dbs.aop.SpringAOPDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//        EmpService s1 = context.getBean(EmpService.class);
//        System.out.println(s1.getClass().getName());
//        s1.setCname("Bhanu");
//        
//        System.out.println();
//        s1.applyNow();
//        System.out.println();
//        
        CustomerServiceImpl c1 = context.getBean(CustomerServiceImpl.class);
//        System.out.println(c1.getClass().getName());
//        c1.applyForChequeBook(123);
//        
//        try {
//        	s1.applyThen();
//        }
//        catch(Exception e) {
//        	
//        }
        System.out.println(c1.balance(5000));
    }
}
