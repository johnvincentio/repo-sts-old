package com.idc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.idc.model.Product;

@Component
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Product product) {
		em.persist(product);
	}

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
	}

	public Product get(Integer id) {
		return em.find(Product.class, id);
	}

	public void delete(Integer id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
	}
}
