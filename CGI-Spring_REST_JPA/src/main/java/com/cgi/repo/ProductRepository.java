package com.cgi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cgi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
