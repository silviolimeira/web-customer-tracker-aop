package com.sl.springdemo.dao;

import java.util.List;

import com.sl.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
