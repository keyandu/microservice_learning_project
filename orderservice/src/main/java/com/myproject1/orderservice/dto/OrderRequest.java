package com.myproject1.orderservice.dto;

import java.math.BigDecimal;
import java.util.List;

import com.myproject1.orderservice.model.OrderLineItems;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
	//private String orderNumber;
	private List<OrderLineItemsDto> orderLineItemList;
}
