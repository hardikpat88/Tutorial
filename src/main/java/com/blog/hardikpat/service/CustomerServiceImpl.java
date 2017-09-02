package com.blog.hardikpat.service;

import java.util.List;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.hardikpat.dao.CustomerRepository;
import com.blog.hardikpat.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	@Setter
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	public Customer saveCustomerData(Customer customer){
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerByName(String Name) {
		// TODO Auto-generated method stub
		return (List<Customer>)customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.delete(customer);
	}
	
	@Override
	public Customer getCustomerByCustId(String id) {
		// TODO Auto-generated method stub
		return  customerRepository.findByCustId(id);
	}
}
