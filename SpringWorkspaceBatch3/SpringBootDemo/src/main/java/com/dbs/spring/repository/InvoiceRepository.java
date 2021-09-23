package com.dbs.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dbs.spring.model.Invoices;

public interface InvoiceRepository extends CrudRepository<Invoices,String> {
		
	public List<Invoices> findAllByProductPid(int pid);
}
