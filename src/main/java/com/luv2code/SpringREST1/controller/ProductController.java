package com.luv2code.SpringREST1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringREST1.dao.ProductRepository;
import com.luv2code.SpringREST1.entity.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/")
	public List<Product> getProducts() {
		return repository.findAll();
				
	}
	
	
	@GetMapping("/{id}")
	public Product getProductById( @PathVariable Long id ) {
		
	  return repository.findById(id).get();
		
	}
	
	
	
	
	//@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
	//public void addMember(@RequestBody Member member) {
	//    //code
	//}

}
