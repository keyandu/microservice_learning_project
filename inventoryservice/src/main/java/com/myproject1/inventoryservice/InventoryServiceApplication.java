package com.myproject1.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.myproject1.inventoryservice.model.Inventory;
import com.myproject1.inventoryservice.repository.InventoryRepository;


@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	
		
	
	}
	
	@Bean
	public CommandLineRunner loadData(InventoryRepository inventroyRepository) {
		return args->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(100);
			
			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_red");
			inventory1.setQuantity(0);
			inventroyRepository.save(inventory);
			inventroyRepository.save(inventory1);
		};
	}

}
