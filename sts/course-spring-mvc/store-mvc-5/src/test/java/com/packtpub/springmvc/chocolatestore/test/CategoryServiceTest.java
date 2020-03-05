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
import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class CategoryServiceTest {

	@Autowired
	CategoryService categoryService;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {
		Assert.assertEquals(2,  categoryService.countAllCategories());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDelete() {
		Assert.assertEquals(2,  categoryService.countAllCategories());
		Category category = Utils.makeCategory(1);
		categoryService.saveCategory(category);		// add
		Assert.assertEquals(3,  categoryService.countAllCategories());

		categoryService.deleteCategory(category);	// delete
		Assert.assertEquals(2,  categoryService.countAllCategories());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testGetAllCategories() {
		Assert.assertEquals(2,  categoryService.countAllCategories());
		List<Category> list = categoryService.getAllCategories();
		Assert.assertEquals(2, list.size());
		Category category1 = list.get(0);
		Assert.assertNotNull(category1);
		Assert.assertEquals(1L, category1.getId().longValue());
		Assert.assertEquals("Truffles", category1.getName());
		Assert.assertEquals("Truffles", category1.getDescription());

		Category category2 = list.get(1);
		Assert.assertNotNull(category2);

		List<Product> list2 = category1.getProducts();
		Assert.assertNotNull(list2);
		Assert.assertEquals(4, list2.size());
		Product product1 = list2.get(0);
		Assert.assertNotNull(product1);
		Assert.assertEquals("Dark Chocolate Truffle", product1.getName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindCategory() {
		Category category = categoryService.findCategory(1L);
		Assert.assertNotNull(category);
		Assert.assertEquals(1L, category.getId().longValue());
		Assert.assertEquals("Truffles", category.getName());
		Assert.assertEquals("Truffles", category.getDescription());
		
		List<Product> list = category.getProducts();
		Assert.assertNotNull(list);
		Assert.assertEquals(4, list.size());
		Product product = list.get(0);
		Assert.assertNotNull(product);
		Assert.assertEquals("Dark Chocolate Truffle", product.getName());
	}
}
