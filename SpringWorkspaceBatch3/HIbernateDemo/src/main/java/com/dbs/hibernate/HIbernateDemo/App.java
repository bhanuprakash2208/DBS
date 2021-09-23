package com.dbs.hibernate.HIbernateDemo;

import java.util.List;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.dbs.hibernate.HIbernateDemo.model.Customer;
import com.dbs.hibernate.HIbernateDemo.model.Invoices;
import com.dbs.hibernate.HIbernateDemo.model.Product;

public class App 
{
	private static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	//HibConfig.getSessionFactory();
    	System.out.println("Connected to Database");
    	Customer c1 = new Customer("Shalini", "Mumbai", "shalini@gmail.com", "Passport", 83789237, false);
    	Customer c2 = new Customer("Chandana", "Pune", "chandana@gmail.com", "Aadhar", 9898998, true);
    	Customer c3 = new Customer("Gautham", "Hyderabad", "gautham@gmail.com", "License", 19998908, false);
		Customer c4 = new Customer("Raghu", "Hyderabad", "Raghu@gmail.com", "License", 19998908, false);
		Customer c5 = new Customer("Rachita", "Pune", "Rachita@gmail.com", "License", 19998908, false);
		
		/*
		 * insertCustomer(c3); insertCustomer(c4); insertCustomer(c5);
		 */
		/*
		 * for(Customer c:getAllCustomer()) System.out.println(c);
		 * System.out.println(getCount());
		 * 
		 * System.out.println(); for(Customer c:getAllCustomerByCity("Pune"))
		 * System.out.println(c);
		 */
		
    	  
    	//System.out.println("Insertion of"+ insertCustomer(c1));
    	//insertCustomer(c2);
    	//insertCustomer(c3);
    	
    	//c1.setCustomerAddress("Delhi");
    	//updateCustomer(c1);
    	//deleteCustomer(c3);
    	//System.out.println(getCustomerById(c1.getCustomerEmailId()));
    	//loadCustomerById(c1.getCustomerEmailId());
    	//for(Customer c:getAllCustomer())
    	//	System.out.println(c);
    	
    	Product p1 = new Product(1, "Pencil", 45);
		Product p2 = new Product(2, "Eraser", 15);
		Product p3 = new Product(3, "Sharpener", 5);
		Product p4 = new Product(4, "Ruler", 25);
		/*
		 * createProducts(p1); createProducts(p2); createProducts(p3);
		 * createProducts(p4);
		 */
		Invoices i1 = new Invoices("I001", "Shalini", LocalDate.now(), p1, 10, 10*p1.getPrice());
		
		  //createInvoices(i1);
		 
    	
    }
    
    
	public static void createInvoices(Invoices inv)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(inv);
		tx.commit();
		session.close();
	}
	public static void createProducts(Product p1)
	{
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p1);
		tx.commit();
		session.close();
	}

    
    
	public static long getCount()
	{
		Session session =factory.openSession();
		List<Long> list = session.createQuery("select count(*) from Customer").list();
		session.close();
		return list.get(0);
	}
	public static List<Customer> getAllCustomer()
	{
		Session session =factory.openSession();
		List<Customer> list = session.createQuery("from Customer").list();
		session.close();
		return list;
	}
	public static List<Customer> getAllCustomerByCity(String city)
	{
		Session session =factory.openSession();
		Query q = session.createQuery("from Customer where customerAddress=:addr");
		q.setParameter("addr", city);
		List list = q.list();
		session.close();
		return list;
	}
    
    public static Customer getCustomerById(String emailid) 
    {
    	Session session = factory.openSession();
    	Customer customer = session.get(Customer.class,emailid);
    	session.close();
    	return customer;
    }
    public static void loadCustomerById(String emailid) 
    {
    	Session session = factory.openSession();
    	//System.out.println("Before Session load-------");
    	Customer customer = session.load(Customer.class,emailid);
    	//System.out.println("After Session load---------");
    	//System.out.println("Displaying email id");
    	System.out.println(customer.getCustomerEmailId());
    	//System.out.println("Displaying customer Name");
    	//System.out.println(customer.getCustomerName());
    	//System.out.println("-------------");
    	session.close();

    	//System.out.println(customer.getCustomerName());   
    	//if we use the above line after the session.close() even if the record exist then we will get error
    	
    }
   

    
    public static String insertCustomer(Customer customer)
    {
	// insert
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	String email = (String) session.save(customer);
    	tx.commit();
    	session.close();
    	return  email;
	} 
	public static void updateCustomer(Customer customer)
	{
	// insert
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(customer);
		tx.commit();
		session.close();
	} 
	public static void deleteCustomer(Customer customer)
	{
		// insert
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(customer);
		tx.commit();
		session.close();
	} 

	//
    
    
}
