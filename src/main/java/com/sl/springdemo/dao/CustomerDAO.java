package com.sl.springdemo.dao;

import java.util.List;

import com.sl.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers(Integer theSortField);

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Integer theId);

	public void deleteCustomer(Integer theId);

	public List<Customer> searchCustomers(String theSearchName);

}
