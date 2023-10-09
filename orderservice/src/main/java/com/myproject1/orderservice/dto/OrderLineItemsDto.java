package com.myproject1.orderservice.dto;

import java.math.BigDecimal;

import com.myproject1.orderservice.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDto {
	private String skuCode; 
	private BigDecimal price; 
	private Integer quantity; 
}
