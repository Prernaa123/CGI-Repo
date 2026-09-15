package com.cgi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.entity.Product;
import com.cgi.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private  ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Long id, Product product) {

		Product existingProduct = productRepository.findById(id).orElse(null);

		if (existingProduct == null) {
			return null;
		}

		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());

		return productRepository.save(existingProduct);
	}

	public boolean deleteProduct(Long id) {

		if (!productRepository.existsById(id)) {
			return false;
		}

		productRepository.deleteById(id);
		return true;
	}
}
