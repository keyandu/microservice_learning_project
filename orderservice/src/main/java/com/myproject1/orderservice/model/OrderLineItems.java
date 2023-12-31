package com.myproject1.orderservice.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_order_line_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderLineItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String skuCode; 
	private BigDecimal price; 
	private Integer quantity;
	
	
}
