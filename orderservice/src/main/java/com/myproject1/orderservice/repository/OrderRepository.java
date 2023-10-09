package com.myproject1.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject1.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
