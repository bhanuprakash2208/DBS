package com.dbs.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dbs.spring.database.ProductDatabase;
import com.dbs.spring.model.Invoices;
import com.dbs.spring.model.Product;
import com.dbs.spring.service.InvoiceService;
import com.dbs.spring.service.ProductService;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		ProductDatabase DataBase = context.getBean(ProductDatabase.class);
		//System.out.println(DataBase.getTemplate());
		
		ProductService service = context.getBean(ProductService.class);
		System.out.println(service.getCount());
		
		Product p1 = new Product(5,"Pen", 200 );
		System.out.println("Insertion "+service.insertProduct(p1));
		p1.setPrice(350);
		service.updateProduct(p1);
		
		
		System.out.println("getting product By Id "+service.getProductById(2));
		System.out.println();
		
		for(Product p : service.getProducts())
			System.out.println(p);
		
		System.out.println();
		//System.out.println(service.deleteProduct(5));
		for(Product p : service.findByPriceGreaterThan(20))
			System.out.println(p);
		
		
		InvoiceService invService = context.getBean(InvoiceService.class);
		System.out.println(invService.getInvoiceById("I001"));
		
		System.out.println();
		for(Invoices p:invService.getInvoices())
			System.out.println(p);
		
		System.out.println();
		for(Invoices p:invService.getInvoicesByProductId(1))
			System.out.println(p);
		
		
	}

}
