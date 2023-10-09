package com.myproject1.orderservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.myproject1.orderservice.dto.InventroyResponse;
import com.myproject1.orderservice.dto.OrderLineItemsDto;
import com.myproject1.orderservice.dto.OrderRequest;
import com.myproject1.orderservice.model.Order;
import com.myproject1.orderservice.model.OrderLineItems;
import com.myproject1.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository; 
	private final WebClient.Builder webClientBuilder;
	@Override
	public void placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderItemList = orderRequest.getOrderLineItemList()
			.stream()
			.map(OrderServiceImpl::mapToDto)
			.collect(Collectors.toList());
		
		order.setOrderLineItemList(orderItemList);
		
		
		//get order's order line item list (shopingcart): type string
		List<String> skuCodeList = order.getOrderLineItemList().stream()
			.map(orderLineItem->orderLineItem.getSkuCode())
			.collect(Collectors.toList());
		
		InventroyResponse[] inventoryResponseArray = webClientBuilder.build().get()
				 .uri("http://inventory-service/api/inventory",
						 uriBuilder->uriBuilder.queryParam("skuCode", skuCodeList)
						 .build())
				 .retrieve()
				 .bodyToMono(InventroyResponse[].class)
				 .block();
		
		boolean allProductIsInStock = Arrays.stream(inventoryResponseArray)
				.allMatch(InventroyResponse::isInStock);
		
		if(allProductIsInStock) 
			orderRepository.save(order);
		else {
			throw new IllegalArgumentException("Product is not in stock, plase try again later"); 
		}
		
	}
	static OrderLineItems mapToDto(OrderLineItemsDto orLineDto){
		return OrderLineItems.builder()
				.price(orLineDto.getPrice())
				.quantity(orLineDto.getQuantity())
				.skuCode(orLineDto.getSkuCode()).build();
	}
		

}
