package com.dbs.web.rest;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dbs.web.beans.Product;
import com.dbs.web.beans.ResponsePage;
import com.dbs.web.service.ProductService;
// this inofrms spring that it is a web service
// REST API => http://localhost:8080/products
// mapping for this url with a method
@RestController
@CrossOrigin()
@RequestMapping("/products")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	// generalized form for all HTTP methods
	//@RequestMapping(path = "/products", method = RequestMethod.GET)
	@GetMapping
	public List<Product> findProducts()
	{
		return this.productService.getProducts();
	}
	
	//http://localhost:8080/products/name/Bhanu?price=90&num=2
	@GetMapping("/name/{name}")
	public List<Product> findProducts(
			@RequestParam(required=false) Double price,
			@RequestParam(required=false) Integer num,
			HttpServletRequest request)
			//@PathVariable String name)
	{
		System.out.println(request.getHeader("Accept"));
		System.out.println(request.getMethod());
		System.out.println("price "+price+" " +"num" + num);

		//System.out.println("price "+price+" "+name+" num" + num);
		if(price==null)
			return this.productService.getProducts();
		return this.productService.getProductsByPrice(price);
	}
	
	//http://localhost:8080/products/2
//	@GetMapping("/{pid}")
//	public Product findProductById(@PathVariable int pid)
//	{
//		return this.productService.findProductById(pid);
//	}
	

@GetMapping("/{pid}")
	public ResponseEntity<Object> findProductById(@PathVariable int pid)
	{
		try { 
			Product prod = this.productService.findProductById(pid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(prod);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}
	
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product)
	{
		if(this.productService.updateProduct(product))
			return  ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Product updated with id "+product.getPid());
		return  ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Product not updated with id "+product.getPid());
	}
	//	@PostMapping
	/* 
	 * 
	 * It will print the string as json from postman 
	 * 
	 * */
	//public ResponseEntity<String> insertProduct(@RequestBody String product)
	
//	public ResponseEntity<String> insertProduct(@RequestBody Product product)
//	{
//		System.out.println("Insertion of");
//		System.out.println(product);
//		if(this.productService.insertProduct(product))
//			return  ResponseEntity
//					.status(HttpStatus.ACCEPTED)
//					.body("Product inserted with id "+product.getPid());
//		return  ResponseEntity
//				.status(HttpStatus.NOT_FOUND)
//				.body("Product not inserted with id "+product.getPid());
//	}
	@PostMapping
	public ResponseEntity<String> insertProduct(@RequestBody Product product)
	{
		System.out.println("\ninsert");
		System.out.println(product);
		int id = this.productService.insertProduct(product);
		if( id != -1)
			return  ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body("Product inserted with id "+id);
		return  ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Product not inserted with id "+product.getPid());
	}
	@DeleteMapping("/{pid}")
	public  ResponseEntity<String> deleteProductById(@PathVariable int pid)
	{
		try {
			if(this.productService.deleteProduct(pid))
				return  ResponseEntity
						.status(HttpStatus.ACCEPTED)
						.body("Product deleted with id "+pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return  ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(e.getMessage());
		}
		return  ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body("Product not deleted with id "+pid);
	}
}
