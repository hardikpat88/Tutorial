package com.blog.hardikpat.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import lombok.Setter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.hardikpat.controller.HardikPatApplication;
import com.blog.hardikpat.model.ClaimedEmailAddress;
import com.blog.hardikpat.model.Customer;
import com.blog.hardikpat.model.PostalAddress;
import com.blog.hardikpat.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=HardikPatApplication.class,webEnvironment=WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

	@Autowired
	@Setter
	private CustomerServiceImpl customerService;
	
	@Test
	public void testToCreateCustomer(){
		System.out.println("::::::::Create Customer method start ::::::::");
		Customer customer = new Customer();
		customer.setFirstName("Steve");
		customer.setLastName("Martin");
		customer.setMiddleName("A");
		customer.setCreatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		customer.setActive(1);
		
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.setAddressLine1("A 304");
		postalAddress.setAddressLine2("Sant Boscow Road");
		postalAddress.setCity("London");
		postalAddress.setStreet("Woodland Street");
		postalAddress.setZipcode("452334P2");
		postalAddress.setCountry("United Kingdom");
		postalAddress.setOwner(customer);
		
		List<PostalAddress> postalAddressList = new ArrayList<PostalAddress>();
		postalAddressList.add(postalAddress);
		
		customer.setPostalAddresses(postalAddressList);
		
		ClaimedEmailAddress emailAddress = new ClaimedEmailAddress();
		emailAddress.setAddress("stevema@email.com");
		emailAddress.setCustomer(customer);
		
		List<ClaimedEmailAddress> claimedEmailAddressList = new ArrayList<ClaimedEmailAddress>();
		claimedEmailAddressList.add(emailAddress);
		
		customer.setClaimedEmailAddress(claimedEmailAddressList);
		
		Customer newCustomer = customerService.createCustomer(customer);
		assertNotNull(newCustomer.getCustId());
		System.out.println("Customer is created successfully...");
		System.out.println("Customer id:::"+newCustomer.getCustId());
		System.out.println("Customer Name:::"+newCustomer.getFirstName() + " " + newCustomer.getLastName());
		System.out.println("::::::::Create Customer method end ::::::::");
	}
	
	
	@Test
	public void testToGetCustomerByName(){
		System.out.println("::::::::Get Customer By Name start ::::::::");
		String name="Steve";		
		List<Customer> customerList = customerService.getCustomerByName(name);
		assertNotNull(customerList);
		assertTrue(customerList.size()>0);
		for (Customer cust : customerList){
			assertNotNull(cust.getFirstName());
			assertNotNull(cust.getLastName());
		}
		
		System.out.println("::::::::Get Customer By Name end ::::::::");
	}
	
	@Test
	public void testToDeleteCustomer(){
		System.out.println("::::::::Delete Customer start ::::::::");
		Customer customer = new Customer();
		customer.setFirstName("Andrew");
		customer.setLastName("Smith");
		customer.setMiddleName("A");
		customer.setCreatedDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		customer.setActive(1);
		
		PostalAddress postalAddress = new PostalAddress();
		postalAddress.setAddressLine1("B 507");
		postalAddress.setAddressLine2("Sant Boscow Road");
		postalAddress.setCity("London");
		postalAddress.setStreet("Woodland Street");
		postalAddress.setZipcode("452334P2");
		postalAddress.setCountry("United Kingdom");
		postalAddress.setOwner(customer);
		
		List<PostalAddress> postalAddressList = new ArrayList<PostalAddress>();
		postalAddressList.add(postalAddress);
		
		customer.setPostalAddresses(postalAddressList);
		
		ClaimedEmailAddress emailAddress = new ClaimedEmailAddress();
		emailAddress.setAddress("AndrewSmith@email.com");
		emailAddress.setCustomer(customer);
		
		List<ClaimedEmailAddress> claimedEmailAddressList = new ArrayList<ClaimedEmailAddress>();
		claimedEmailAddressList.add(emailAddress);
		
		customer.setClaimedEmailAddress(claimedEmailAddressList);
		
		Customer newCustomer = customerService.createCustomer(customer);
		assertNotNull(newCustomer.getCustId());
		System.out.println("Customer inserted successfully");
		System.out.println("Customer id:::"+newCustomer.getCustId());
		System.out.println("Customer Name:::"+newCustomer.getFirstName() + " " + newCustomer.getLastName());
		
		customerService.deleteCustomer(newCustomer);
		Customer deletedCustomer = customerService.getCustomerByCustId(newCustomer.getCustId());
		assertTrue(deletedCustomer==null);
		System.out.println("Customer is deleted successfully");
		
		System.out.println("::::::::Delete Customer end ::::::::");
	}
}
