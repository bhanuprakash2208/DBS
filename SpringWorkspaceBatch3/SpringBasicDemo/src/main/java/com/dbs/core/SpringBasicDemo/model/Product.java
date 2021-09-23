package com.dbs.core.SpringBasicDemo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
/*
 * Life cycle 
 * loading
 * instantiating beans
 * initiliazing properties
 * ==> intercept the flow
 * bean factory 
 * 
 */
public class Product implements Comparable<Product> {
	@Value("1")
	private int pid;
	@Value("Television")
	private String pname;
	@Value("40000")
	private double price;
	
	public Product() {
		System.out.println("Product default constructor");
	}

	public Product(
	int pid, String pname, double price) {
		super();
		System.out.println("Product parameterized constructor "+pid);
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		System.out.println("Product set id called "+pid);
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		return this.getPname().compareTo(o.getPname());
	}
	
	
}
