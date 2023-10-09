package com.myproject1.product_service.service;

import java.util.List;

import com.myproject1.product_service.dto.ProductRequest;
import com.myproject1.product_service.dto.ProductResponse;

public interface ProductService {
	public void createProduct(ProductRequest productRequest);
	public List<ProductResponse> getAllProduct();
}
