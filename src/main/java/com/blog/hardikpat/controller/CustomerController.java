package com.blog.hardikpat.controller;

import java.util.List;

import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.hardikpat.model.Customer;
import com.blog.hardikpat.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	@Setter
	private CustomerServiceImpl customerService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		Customer createdCustomer = customerService.createCustomer(customer);
		if(createdCustomer!=null && createdCustomer.getCustId()!=null){
			return new ResponseEntity<Customer>(createdCustomer,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Customer>(createdCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable("name") String name){
		List<Customer> customers = customerService.getCustomerByName(name);
		if(customers!=null && customers.size()>0){
			return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<List<Customer>>(customers,HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id){
		Customer customer = customerService.getCustomerByCustId(id);
		if(customer!=null){
			return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Customer>(customer,HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = customerService.saveCustomerData(customer);
		if(updatedCustomer!=null && updatedCustomer.getCustId()!=null){
			return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
