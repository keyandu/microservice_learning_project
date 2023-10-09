package com.myproject1.product_service.dto;

import java.math.BigDecimal;

import com.myproject1.product_service.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponse {
	private String id;
	private String name;
	private String description;
	private BigDecimal price; 
	
}
