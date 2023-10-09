package com.myproject1.product_service;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject1.product_service.dto.ProductRequest;

import ch.qos.logback.core.status.Status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@Configuration
@ContextConfiguration
class ProductServiceApplicationTests {
	//mongoDB container from testcontainter
	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.1");
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dymDynamicPropertyRegistry) {
		dymDynamicPropertyRegistry.add("spring.data.mongodb.uri",
				mongoDBContainer::getReplicaSetUrl);
	}
	
	//Use ObjectMapper reading and writing JSON,either to and from basic POJOs
	@Autowired
	private ObjectMapper objectMapper;
	
	//server-side Spring MVC test support
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		//MockMVC
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	private ProductRequest getProductRequest() {
		return ProductRequest.builder()
				.name("iPhone 13")
				.description("An iPhone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
	}

}
