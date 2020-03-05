package com.packtpub.springmvc.chocolatestore.test;

import java.util.List;

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
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ProductServiceTest {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {
		Assert.assertEquals(8,  productService.countAllProducts());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFeaturedProducts() {
		List<Product> list1 = productService.getFeaturedProducts();
		Assert.assertEquals(4, list1.size());

		Assert.assertEquals(1, list1.get(0).getId().longValue());
		Assert.assertEquals(2, list1.get(1).getId().longValue());
		Assert.assertEquals(5, list1.get(2).getId().longValue());
		Assert.assertEquals(6, list1.get(3).getId().longValue());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindProductEntries() {
		List<Product> list1 = productService.findProductEntries(3, 20);
		Assert.assertEquals(5, list1.size());

		Assert.assertEquals(4, list1.get(0).getId().longValue());
		Assert.assertEquals(5, list1.get(1).getId().longValue());
		Assert.assertEquals(6, list1.get(2).getId().longValue());
		Assert.assertEquals(7, list1.get(3).getId().longValue());
		Assert.assertEquals(8, list1.get(4).getId().longValue());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindProductById() {
		Product product = productService.findProduct(3L);
		Assert.assertEquals(3, product.getId().longValue());
		Assert.assertEquals("Milk Chocolate Truffle with Cocoa", product.getName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindProduct() {
		Product product = productService.findProduct(3L);
		List<Product> list1 = productService.findProducts(product);
		Assert.assertEquals(1, list1.size());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDelete() {
		Assert.assertEquals(8,  productService.countAllProducts());
		Product product = Utils.makeProduct (1, categoryService.findCategory(1L));
		productService.saveProduct(product);
		Assert.assertEquals(9,  productService.countAllProducts());

		productService.deleteProduct(product);
		Assert.assertEquals(8,  productService.countAllProducts());
	}
}
