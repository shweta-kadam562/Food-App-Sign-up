package com.foodapp.rest.r.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.rest.r.enums.Order;
import com.foodapp.rest.r.model.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> {
	
	 List<FoodItem> findByCustomerIdAndOrderStatus(int customerId, Order orderStatus);
}