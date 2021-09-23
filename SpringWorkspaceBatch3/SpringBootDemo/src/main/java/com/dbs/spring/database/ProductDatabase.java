package com.dbs.spring.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDatabase {

	@Autowired
	private JdbcTemplate template;
	
	public ProductDatabase() {
		System.out.println("Product Database Constructor");
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
}
