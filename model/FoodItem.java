package com.foodapp.rest.r.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.foodapp.rest.r.enums.Order;

@Entity
@Table(name = "fooditem")
public class FoodItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String foodItemName;
	
	@Column(name = "customer_id")
    private int customerId;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Order orderStatus;
	
	@ManyToOne
	private Category category;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Order getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Order orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
}
