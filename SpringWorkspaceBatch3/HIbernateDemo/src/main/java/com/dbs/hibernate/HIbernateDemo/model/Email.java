package com.dbs.hibernate.HIbernateDemo.model;

import javax.persistence.*;

@Entity
//@Embeddable
public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String emailid;
	
	@ManyToOne
	@JoinColumn(name = "empid")
	private Employee employee;
	
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(int id, String emailid) {
		super();
		this.id = id;
		this.emailid = emailid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "Email [id=" + id + ", emailid=" + emailid + "]";
	}
	
	
}
