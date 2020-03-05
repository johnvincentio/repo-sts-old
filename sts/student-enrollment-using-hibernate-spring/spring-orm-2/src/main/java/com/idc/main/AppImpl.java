package com.idc.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.idc.model.Product;
import com.idc.service.ProductService;

public class AppImpl {

	@Autowired
	ProductService productService;

	public void doit_1() {
		System.out.println(">>> doit_1");
		productService.add(new Product(1, "Bulb"));				// Do some data operation
		productService.add(new Product(2, "Dijone mustard"));
		listAll("after added 1 & 2");

		try {			// Test transaction rollback (duplicated key)
			productService.addAll(Arrays.asList(new Product(3, "Book"), new Product(4, "Soap"), new Product(1, "Computer")));
		}
		catch (DataAccessException dataAccessException) {
		}

		// Test element list after rollback
		listAll("after rollback");
		System.out.println("<<< doit_1");
	}

	public void doit_2() {
		System.out.println(">>> doit_2");
		listAll("list all");
		Product p = productService.get(1);
		System.out.println("1 :"+p+":");
		System.out.println("<<< doit_2");
	}

	public void doit_3() {
		System.out.println(">>> doit_3");
		listAll("list before delete 1");
		productService.delete(1);
		System.out.println("deleted");
		listAll("list after delete 1");

		List<Product> list = productService.listAll();
		for (Product product : list) {
			System.out.println("product :"+product+":");
			productService.delete(product.getId());
		}
		listAll("list after delete from list");
		System.out.println("<<< doit_3");
	}

	private void listAll(String msg) {
		System.out.println(">>> listAll; "+msg);
		List<Product> list = productService.listAll();
		for (Product product : list) {
			System.out.println("product :"+product+":");
		}
		System.out.println("<<< listAll; "+msg);
	}
}
