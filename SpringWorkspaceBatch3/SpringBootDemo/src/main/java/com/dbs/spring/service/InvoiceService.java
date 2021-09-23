package com.dbs.spring.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.spring.model.Invoices;
import com.dbs.spring.repository.InvoiceRepository;
@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository repo;
	
	public long getCount()
	{
		return  this.repo.count();
	}
	public Invoices getInvoiceById(String no)
	{
		return this.repo.findById(no).get();
	}
	public List<Invoices> getInvoices()
	{
		List<Invoices> invoices = new ArrayList<Invoices>();
		this.repo.findAll().forEach(inv -> invoices.add(inv));	
		System.out.println("Size "+invoices.size());
		return invoices;
	}
	
	public List<Invoices> getInvoicesByProductId(int pid)
	{
		List<Invoices> invoices = new ArrayList<Invoices>();
		this.repo.findAllByProductPid(pid).forEach(inv -> invoices.add(inv));
		return invoices;
	}
	
}
