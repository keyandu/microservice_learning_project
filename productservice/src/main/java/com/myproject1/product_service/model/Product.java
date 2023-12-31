package com.myproject1.product_service.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value="product")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
	private String id;
	private String name;
	private String description;
	private BigDecimal price; 
}
