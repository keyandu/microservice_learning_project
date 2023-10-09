package com.myproject1.inventoryservice.service;

import java.util.List;

import com.myproject1.inventoryservice.dto.InventroyResponse;

public interface InventoryService {
	public List<InventroyResponse> isInStock(List<String> skuCode);
}
