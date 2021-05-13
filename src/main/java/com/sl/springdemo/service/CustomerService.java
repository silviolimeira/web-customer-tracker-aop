package com.sl.springdemo.service;

import java.util.List;

import org.springframework.ui.Model;

import com.sl.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers(Integer theSortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Integer theId);

	public void deleteCustomer(Integer theId);

	public List<Customer> searchCustomers(String theSearchName);

}
