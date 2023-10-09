package com.myproject1.inventoryservice.service;



import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject1.inventoryservice.dto.InventroyResponse;
import com.myproject1.inventoryservice.model.Inventory;
import com.myproject1.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Transactional(readOnly=true)
	@Override
	public List<InventroyResponse> isInStock(List<String> skuCode) {
			List<InventroyResponse> res = inventoryRepository.findBySkuCodeIn(skuCode).stream()
				.map(inventory ->
					InventroyResponse.builder()
						.skuCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity()>0)
						.build()
				).collect(Collectors.toList());
		return res;
	} 



}
