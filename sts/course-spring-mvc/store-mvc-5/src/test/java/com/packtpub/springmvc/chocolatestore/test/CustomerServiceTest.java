package com.packtpub.springmvc.chocolatestore.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.springmvc.chocolatestore.app.Utils;
import com.packtpub.springmvc.chocolatestore.config.ApplicationConfig;
import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CustomerServiceTest {
	
	@Autowired
	CustomerService customerService;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {
		Assert.assertEquals(4,  customerService.countAllCustomers());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDelete() {
		Assert.assertEquals(4,  customerService.countAllCustomers());
		Customer customer = Utils.makeCustomer(1);
		customerService.saveCustomer(customer);
		Assert.assertEquals(5,  customerService.countAllCustomers());

		customerService.deleteCustomer(customer);
		Assert.assertEquals(4,  customerService.countAllCustomers());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testLogin() {
		Customer customer = customerService.loginCustomer("testtest", "test");
		Assert.assertNotNull(customer);
		System.out.println("customer.getName() "+customer.getName());
		Assert.assertEquals("testtest", customer.getName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testLoginError() {
		Customer customer = customerService.loginCustomer("user", "pwd");
		Assert.assertNull(customer);
	}
}
