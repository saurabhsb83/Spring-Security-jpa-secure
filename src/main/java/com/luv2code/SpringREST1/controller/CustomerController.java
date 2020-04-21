package com.luv2code.SpringREST1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringREST1.dao.CustomerRepository;
import com.luv2code.SpringREST1.entity.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository repository;
	
	@GetMapping("/")
	public List<Customer> getCustomers() {
		
	//	try {
	//		Thread.sleep(10000);
	//	} catch (InterruptedException e) {
	
	//		e.printStackTrace();
	//	}
		return (List<Customer>) repository.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Customer getCustomerById( @PathVariable int id) {
		
		return repository.findById(id).get();
	}
	
	@PostMapping(path = "/" , consumes = "application/json", produces = "application/json")
	public Customer saveCustomer( @RequestBody Customer customer) {
	
		  Customer theCustomer = repository.save(customer);
		  //Integer id = theCustomer.getId();
		  
		  
		  //enter custom code
		  System.out.println("Hello Development team !!");
		  
		  return repository.findById(theCustomer.getId()).get();
	}
	
	
	@PutMapping(path="/{id}", consumes="application/json", produces="application/json")
	public Customer modifyCustomer( @PathVariable int id, @RequestBody Customer customer) {
		
		customer.setId(id);
		Customer theCustomer = repository.save(customer);
		
		return repository.findById(theCustomer.getId()).get();
		
	}
	
	
	@DeleteMapping("/{id}")
	public List<Customer> removeCustomer( @PathVariable int id) {
		
		repository.deleteById(id);
		return (List<Customer>) repository.findAll();
	}
	
	
	
	
	

}





















