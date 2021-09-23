package com.dbs.project.LoanProposalProject;

import org.hibernate.SessionFactory;

public class App 
{
	private static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
       System.out.println("Working");
    }
}
