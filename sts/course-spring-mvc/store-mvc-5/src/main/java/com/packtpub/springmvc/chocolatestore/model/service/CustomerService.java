package com.packtpub.springmvc.chocolatestore.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.dao.CustomerDao;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	public long countAllCustomers() {
        return customerDao.countCustomers();
    }

	public void deleteCustomer(Customer customer) {
		customerDao.remove(customer);
    }

	public Customer findCustomer(Long id) {
        return customerDao.findCustomer(id);
    }
	
	public List<Customer> findCustomer(String name) {
		return customerDao.findCustomerByName(name);
    }

	public List<Customer> findAllCustomers() {
        return customerDao.findAllCustomers();
    }

	public List<Customer> findCustomerEntries(int firstResult, int maxResults) {
        return customerDao.findCustomerEntries(firstResult, maxResults);
    }

	public void saveCustomer(Customer customer) {
		customerDao.persist(customer);
    }

	public Customer updateCustomer(Customer customer) {
        return customerDao.merge(customer);
    }

	public Customer loginCustomer(String userId, String password) {
		List<Customer> list = this.findCustomer(userId);
		if (list.size() < 1) return null;
		Customer customer = list.get(0);
		if (customer != null && customer.getPassword().equals(password)) return customer;
		return null;
	}
}
