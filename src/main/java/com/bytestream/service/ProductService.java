package com.bytestream.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestream.model.Product;
import com.bytestream.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		return repo.findAll();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Optional<Product> getProduct(Long id) {
		return repo.findById(id);
	}
	
	public void add(Product product)
	{
		repo.save(product);
	}

}
