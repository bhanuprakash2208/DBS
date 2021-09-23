package com.dbs.hibernate.HIbernateDemo.model;

import java.util.List;

import java.util.Set;

import javax.persistence.*;

@Entity
public class Employee {
	
	@Id
	private int eid;
	private String ename;
	private String city;
	
	@ElementCollection
	private Set<String> certificates;
	
	@ElementCollection
	@JoinTable(name = "numbers",
				joinColumns = @JoinColumn(name = "empid")
	)
	private List<String> phonenumbers;
	
	@OneToMany(mappedBy = "employee")
	private List<Email> emailids;

	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Set<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
	}

	public List<String> getPhonenumbers() {
		return phonenumbers;
	}

	public void setPhonenumbers(List<String> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public List<Email> getEmailids() {
		return emailids;
	}

	public void setEmailids(List<Email> emailids) {
		this.emailids = emailids;
	}
	
	

}
