package com.dbs.web.service;

import com.dbs.web.beans.Customer;

public class CustomerService {

	

	public CustomerService() {
		System.out.println("Customer service");
	}

	public Customer findCustomerByEmail(String email) throws Exception
	{
			return null;

	}

	public boolean addCustomer(Customer customer) throws Exception {

		
		return true;
	}
	public boolean updateCustomer(Customer customer) throws Exception {

		
		return false;
	}

}
