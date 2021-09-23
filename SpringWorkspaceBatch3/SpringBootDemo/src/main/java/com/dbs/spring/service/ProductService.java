package com.dbs.spring.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dbs.spring.model.Product;
import com.dbs.spring.repository.ProductRepository;
@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public long getCount()
	{
		return this.repo.count();
	}
	public boolean insertProduct(Product product)
	{
		if(this.repo.existsById(product.getPid()))
			return false;
		try {
			this.repo.save(product);
			
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("product is empty");
		}
		return true;
	}
	public boolean updateProduct(Product product)
	{
		if(! this.repo.existsById(product.getPid()))
			return false;
		try {
			this.repo.save(product);
			
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("product is empty");
		}
		return true;
	}
	public boolean deleteProduct(int id)
	{
		if(! this.repo.existsById(id))
			return false;
		try {
			this.repo.deleteById(id);
			
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("product is empty");
		}
		return true;
	}
	public Product getProductById(int pid)
	{
		// Optional interface
//		Optional<Product> product = this.repo.findById(pid);
//		if(product.isPresent())
//			return product.get();
//		throw new EntityNotFoundException("Product does not exist with id "+pid);
		
		return this.repo.findById(pid)
				.orElseThrow(()->  new EntityNotFoundException("Product does not exist with id "+pid));
	}
	public List<Product> getProducts()
	{
		List<Product> products = new ArrayList<Product>();
		this.repo.findAll().forEach(product -> products.add(product));
		return products;
	}
	
	public List<Product> findByPriceGreaterThan(double price){
		
		List<Product> products = new ArrayList<Product>();
		this.repo.findByPriceGreaterThan(price).forEach(product -> products.add(product));
		return products;
		
	}
}

