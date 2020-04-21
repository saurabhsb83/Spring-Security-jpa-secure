package com.luv2code.SpringREST1.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.SpringREST1.entity.Product;




@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	//url to access: http://localhost:8080/api/products/search/findByCategoryId?id=xx
	
	Page<Product> findByCategoryId( @RequestParam("id") Long id, Pageable pageable );

}
