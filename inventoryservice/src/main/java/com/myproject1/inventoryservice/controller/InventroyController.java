package com.myproject1.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myproject1.inventoryservice.dto.InventroyResponse;
import com.myproject1.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventroyController {
	@Autowired
	private InventoryService inventoryService;
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<InventroyResponse> isInStock(@RequestParam List<String> skuCode) {
		return inventoryService.isInStock(skuCode);
	}
}
