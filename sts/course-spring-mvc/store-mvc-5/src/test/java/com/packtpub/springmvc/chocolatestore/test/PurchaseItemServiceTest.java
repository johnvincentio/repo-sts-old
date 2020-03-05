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
import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.Purchase;
import com.packtpub.springmvc.chocolatestore.model.PurchaseItem;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;
import com.packtpub.springmvc.chocolatestore.model.service.PurchaseItemService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class PurchaseItemServiceTest {

	@Autowired
	PurchaseItemService purchaseItemService;

	@Autowired
	ProductService productService;

	@Test
	@Transactional
	@Rollback(true)
	public void test1() {
		Assert.assertEquals(8,  purchaseItemService.countAllPurchaseItems());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindPurchaseItem() {
		PurchaseItem purchaseItem = purchaseItemService.findPurchaseItem(2L);
		System.out.println("purchaseItem (2) :"+purchaseItem);
		Assert.assertEquals(2, purchaseItem.getId().intValue());
		Assert.assertEquals(2, purchaseItem.getQuantity());
		Assert.assertEquals(1, purchaseItem.getProduct().getId().intValue());
		Assert.assertEquals("Dark Chocolate Truffle",  purchaseItem.getProduct().getName());
		Assert.assertEquals(1, purchaseItem.getProduct().getCategory().getId().intValue());
		Assert.assertEquals("Truffles", purchaseItem.getProduct().getCategory().getName());
		Assert.assertEquals(1, purchaseItem.getPurchase().getId().intValue());
		Assert.assertEquals(3, purchaseItem.getPurchase().getOrderedBy().getId().intValue());
		Assert.assertEquals("shopOwner", purchaseItem.getPurchase().getOrderedBy().getName());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testFindPurchaseItemEntries() {
		List<PurchaseItem> list = purchaseItemService.findPurchaseItemEntries(2, 4);
		Assert.assertEquals(4,  list.size());

		Assert.assertEquals(3, list.get(0).getId().intValue());
		Assert.assertEquals(4, list.get(1).getId().intValue());
		Assert.assertEquals(5, list.get(2).getId().intValue());
		Assert.assertEquals(6, list.get(3).getId().intValue());

		Assert.assertEquals(2, list.get(0).getProduct().getId().intValue());
		Assert.assertEquals(2, list.get(1).getProduct().getId().intValue());
		Assert.assertEquals(3, list.get(2).getProduct().getId().intValue());
		Assert.assertEquals(3, list.get(3).getProduct().getId().intValue());
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDelete() {
		Assert.assertEquals(8,  purchaseItemService.countAllPurchaseItems());

		Customer customer = Utils.makeCustomer (1); 
		Purchase purchase = Utils.makePurchase (1, customer);
		Product product = productService.findProduct(3L);
		PurchaseItem purchaseItem = Utils.makePurchaseItem(1, product, purchase);
		purchaseItemService.savePurchaseItem(purchaseItem);		// add
		Assert.assertEquals(9,  purchaseItemService.countAllPurchaseItems());

		purchaseItemService.deletePurchaseItem(purchaseItem);	// delete
		Assert.assertEquals(8,  purchaseItemService.countAllPurchaseItems());
	}
	

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdate() {
		PurchaseItem purchaseItem = purchaseItemService.findPurchaseItem(2L);
		System.out.println("purchaseItem (2) :"+purchaseItem);
		Assert.assertEquals(2, purchaseItem.getId().intValue());
		Assert.assertEquals(2, purchaseItem.getQuantity());

		purchaseItem.setQuantity(6);
		purchaseItemService.updatePurchaseItem(purchaseItem);
		Assert.assertEquals(6, purchaseItem.getQuantity());
		
		purchaseItem.setQuantity(2);
		purchaseItem = purchaseItemService.updatePurchaseItem(purchaseItem);
		Assert.assertEquals(2, purchaseItem.getQuantity());
	}
}
