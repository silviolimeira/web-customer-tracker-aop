package com.sl.springdemo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sl.springdemo.dao.CustomerDAO;
import com.sl.springdemo.entity.Customer;
import com.sl.springdemo.util.SortUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	CustomerDAO customerDAO;
	
	public CustomerServiceImpl() { }
	
	@Override
	@Transactional
	public List<Customer> getCustomers(Integer theSortField) {
		return customerDAO.getCustomers(theSortField);
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(Integer theId) {
		
		return customerDAO.getCustomer(theId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(Integer theId) {
		
		customerDAO.deleteCustomer(theId);
		
	}
	
	@Override
    @Transactional
    public List<Customer> searchCustomers(String theSearchName) {
        return customerDAO.searchCustomers(theSearchName);
    }

}
