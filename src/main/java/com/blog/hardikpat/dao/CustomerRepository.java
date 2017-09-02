package com.blog.hardikpat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.blog.hardikpat.model.Customer;

@RepositoryRestResource(collectionResourceRel="Customer",path="Customer")
public interface CustomerRepository extends CrudRepository<Customer,String>{

	public Customer findByCustId(String Id);
}
