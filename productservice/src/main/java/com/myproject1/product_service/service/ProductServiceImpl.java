package com.myproject1.product_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject1.product_service.dto.ProductRequest;
import com.myproject1.product_service.dto.ProductResponse;
import com.myproject1.product_service.model.Product;
import com.myproject1.product_service.repo.ProductRepository;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		productRepository.save(product);
		log.info("Product {} is saved",product.getId());
	}
	@Override
	public List<ProductResponse> getAllProduct() {
		List<ProductResponse> product = productRepository.findAll()
				.stream().map(p->ProductResponse.builder()
						.id(p.getId())
						.name(p.getName())
						.description(p.getDescription())
						.price(p.getPrice())
						.build())
				.collect(Collectors.toList());
		return product;
	}
	
}
