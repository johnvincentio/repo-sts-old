package com.packtpub.springmvc.chocolatestore.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.springmvc.chocolatestore.config.ApplicationConfig;
import com.packtpub.springmvc.chocolatestore.model.service.PurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class PurchaseServiceTest {

	@Autowired
	PurchaseService purchaseService;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {
		Assert.assertEquals(4,  purchaseService.countAllPurchases());
	}

}

/*
	public void doit_4() {					// Purchase, fk customer.id
		System.out.println(">>> doit_4");
		listAllPurchase("list all at start");	// list

		List<PurchaseItem> list_2 = purchaseItemService.findPurchaseItemEntries(2, 4);
		for (PurchaseItem item : list_2) {
			System.out.println("(2,4) PurchaseItem :"+item+":");
		}

		PurchaseItem purchaseItem = purchaseItemService.findPurchaseItem(2L);
		System.out.println("purchaseItem (2) :"+purchaseItem);

		listAllPurchaseItems("list all before add");
		Product product = productService.findProduct(3L);
		purchaseItem = Utils.makePurchaseItem (1, product);
		purchaseItemService.savePurchaseItem(purchaseItem);
		listAllPurchaseItems("list all after add");

		listAllProducts("list all before add");
		product = Utils.makeProduct (1, categoryService.findCategory(1L));
		productService.saveProduct(product);
		listAllProducts("list all after add");

		System.out.println("product before update :"+product+":");
		product.setFeatured(true);
		productService.updateProduct(product);
		System.out.println("product after update :"+product+":");

		productService.deleteProduct(product);
		listAllProducts("list all after delete");

		System.out.println("<<< doit_4");
	}
*/
