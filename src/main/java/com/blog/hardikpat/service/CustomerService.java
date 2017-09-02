package com.blog.hardikpat.service;

import java.util.List;

import com.blog.hardikpat.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public Customer saveCustomerData(Customer customer);
	
	public List<Customer> getCustomerByName(String Name);
	
	public void deleteCustomer(Customer customer);
	
	public Customer getCustomerByCustId(String id);
}
