package com.packtpub.springmvc.chocolatestore.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.packtpub.springmvc.chocolatestore.model.Category;
import com.packtpub.springmvc.chocolatestore.model.Customer;
import com.packtpub.springmvc.chocolatestore.model.Product;
import com.packtpub.springmvc.chocolatestore.model.Purchase;
import com.packtpub.springmvc.chocolatestore.model.PurchaseItem;

public class Utils {

	public static Customer makeCustomer (int id) {
		Customer customer = new Customer();
		customer.setName("name_" + id);
		customer.setEmail("name_" + id+ "@email.com");
		customer.setFirstName("first_"+id);
		customer.setLastName("last_"+id);
		customer.setPassword("password_"+id);
		customer.setPhone("phone_"+id);
		return customer;
	}

	public static Category makeCategory(int id) {
		Category category = new Category();
		category.setName("aaaa_"+id);
		category.setDescription("desc_"+id);
		return category;
	}

	public static Product makeProduct (int id, Category category) {
		Product product = new Product();
		product.setDescription("desc_"+id);
		product.setFeatured(false);
		product.setImagePath("image_path_"+id);
		product.setPrice(123.45);
		product.setName("name_"+id);
		product.setCategory(category);
		return product;
	}

	public static Purchase makePurchase (int id, Customer customer) {
		Purchase item = new Purchase();
		item.setVersion(1);
		item.setCompleted(true);
		item.setOrderDate(new GregorianCalendar(2013,1,28,13,24,56));
		item.setOrderedBy(customer);
		return item;
	}

	public static PurchaseItem makePurchaseItem (int id, Product product, Purchase purchase) {
		PurchaseItem item = new PurchaseItem();
		item.setVersion(1);
		item.setQuantity(4);
		item.setOrderDate(new GregorianCalendar(2013,1,28,13,24,56));
		item.setProduct(product);
//		item.setPurchase(purchase);
		return item;
	}

	public static String formatDate(Calendar calendar) {
		String pattern = "MM/dd/yyyy hh:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(calendar.getTime());
	}
}
