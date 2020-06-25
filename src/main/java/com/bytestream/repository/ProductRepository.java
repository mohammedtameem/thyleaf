package com.bytestream.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytestream.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
