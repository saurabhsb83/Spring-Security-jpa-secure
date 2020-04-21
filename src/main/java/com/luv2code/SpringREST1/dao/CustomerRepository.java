package com.luv2code.SpringREST1.dao;

import org.springframework.data.repository.CrudRepository;

import com.luv2code.SpringREST1.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
