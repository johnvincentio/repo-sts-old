package com.packtpub.springmvc.chocolatestore.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.Purchase;
import com.packtpub.springmvc.chocolatestore.model.PurchaseItem;
import com.packtpub.springmvc.chocolatestore.model.service.CategoryService;
import com.packtpub.springmvc.chocolatestore.model.service.CustomerService;
import com.packtpub.springmvc.chocolatestore.model.service.ProductService;
import com.packtpub.springmvc.chocolatestore.model.service.PurchaseItemService;
import com.packtpub.springmvc.chocolatestore.model.service.PurchaseService;

public class AppImpl {

	@Autowired
	CustomerService customerService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	@Autowired
	PurchaseService purchaseService;

	@Autowired
	PurchaseItemService purchaseItemService;

	public void doit_1() {					// Customer
		System.out.println(">>> doit_1");
		listAllCustomers("before add");
		Customer customer = Utils.makeCustomer(1);
		customerService.saveCustomer(customer);
		listAllCustomers("after add");

		customerService.deleteCustomer(customer);	// delete
		System.out.println("after delete");
		listAllCustomers("list all after delete");
		System.out.println("<<< doit_1");
	}

	public void doit_2() {					// Category
		System.out.println(">>> doit_2");
		listAllCategories("list all before add");	// list

		Category category = Utils.makeCategory(1);
		categoryService.saveCategory(category);		// add
		listAllCategories("list all after add");
		System.out.println("category :"+category+":");

		categoryService.deleteCategory(category);	// delete
		System.out.println("after delete");
		listAllCategories("list all after delete");

		System.out.println("<<< doit_2");
	}

	public void doit_3() {					// Product, fk category.id
		System.out.println(">>> doit_3");
		listAllProducts("list all at start");	// list

		List<Product> list_1 = productService.getFeaturedProducts();
		for (Product product : list_1) {
			System.out.println("featured product :"+product+":");
		}

		long count = productService.countAllProducts();
		System.out.println("count "+count);

		List<Product> list_2 = productService.findProductEntries(3, 5);
		for (Product product : list_2) {
			System.out.println("(3,5) product :"+product+":");
		}

		Product product = list_2.get(3);
		List<Product> list_3 = productService.findProducts(product);
		for (Product item : list_3) {
			System.out.println("findProducts item :"+item+":");
		}

		product = productService.findProduct(3L);
		System.out.println("product (3) "+product);

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
		System.out.println("<<< doit_3");
	}

	public void doit_4() {					// Purchase, fk customer.id
		System.out.println(">>> doit_4");
		listAllPurchase("list all at start");	// list
		System.out.println("<<< doit_4");
	}

	public void doit_5() {					// PurchaseItem, fk product.id
		System.out.println(">>> doit_5");
		listAllPurchaseItems("list all at start");	// list
		System.out.println("<<< doit_5");
	}

	private void listAllCustomers(String msg) {
		System.out.println(">>> listAllCustomers; "+msg);
		List<Customer> list = customerService.findAllCustomers();
		for (Customer customer : list) {
			System.out.println("customer :"+customer+":");
		}
		System.out.println("<<< listAllCustomers; "+msg);
	}
	private void listAllCategories(String msg) {		// cannot show products as lazy loaded.
		System.out.println(">>> listAllCategories; "+msg);
		List<Category> list = categoryService.getAllCategories();
		for (Category category : list) {
			System.out.println("category :"+category+":");
		}
		System.out.println("<<< listAllCategories; "+msg);
	}
	private void listAllProducts(String msg) {
		System.out.println(">>> listAllProducts; "+msg);
		List<Product> list = productService.findAllProducts();
		for (Product product : list) {
			System.out.println("product :"+product+":");
		}
		System.out.println("<<< listAllProducts; "+msg);
	}
	private void listAllPurchase(String msg) {
		System.out.println(">>> listAllPurchase; "+msg);
		List<Purchase> list = purchaseService.findAllPurchases();
		for (Purchase purchase : list) {
			System.out.println("purchase :"+purchase.myString()+":");
		}
		System.out.println("<<< listAllPurchase; "+msg);
	}
	private void listAllPurchaseItems(String msg) {
		System.out.println(">>> listAllPurchaseItems; "+msg);
		List<PurchaseItem> list = purchaseItemService.findAllPurchaseItems();
		for (PurchaseItem purchaseItem : list) {
			System.out.println("purchaseItem :"+purchaseItem+":");
		}
		System.out.println("<<< listAllPurchaseItems; "+msg);
	}
}
