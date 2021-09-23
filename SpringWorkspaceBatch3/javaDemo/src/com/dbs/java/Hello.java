package com.dbs.java;

public class Hello {
	private int sno;
	

	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public Hello() {

		// TODO Auto-generated constructor stub
	}


	public Hello(int sno) {
		super();
		this.sno = sno;
	}


	@Override
	public String toString() {
		return "Hello [sno=" + sno + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		String s = "bhanu";
		System.out.println(s.toUpperCase());
		

	}

}
