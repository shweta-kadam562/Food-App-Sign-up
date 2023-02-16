package com.foodapp.rest.r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.rest.r.enums.Order;
import com.foodapp.rest.r.model.FoodItem;
import com.foodapp.rest.r.repo.FoodItemRepo;

@Service
public class FoodItemService {
	 @Autowired
	    private FoodItemRepo foodItemRepo;

	public void postFoodItem(FoodItem foodItem) {
		foodItemRepo.save(foodItem);

	}

	public List<FoodItem> getAllFoodItem() {
		// TODO Auto-generated method stub
		return foodItemRepo.findAll();
	}

	public Optional<FoodItem> getById(int id) {
		// TODO Auto-generated method stub
		Optional<FoodItem> optional = foodItemRepo.findById(id);
		return optional;
	}

	public void deleteFoodItemById(int id) {
		// TODO Auto-generated method stub
		foodItemRepo.deleteById(id);
	}
public void updateFoodItemById(FoodItem foodItem) {

	foodItemRepo.save(foodItem);
}

public List<FoodItem> getFoodItemsByCustomerIdAndStatus(int customerId, Order orderStatus) {
    return foodItemRepo.findByCustomerIdAndOrderStatus(customerId, orderStatus);
}

//public List<FoodItem> getFoodItemByCustomerId(int cid) {
//	List<FoodItem> list = foodItemRepo.findAll();
//	
//	List<FoodItem> filteredList = 
//			list.stream() 
//				.filter(e->e.getCategory().getId() == cid)
//				.collect(Collectors.toList());
//	
//	return filteredList;
//}

//public List<FoodItem> getFoodItemByCategory(String category) {
//	List<FoodItem> list = foodItemRepo.findAll();
//	List<FoodItem> filteredList = list.stream()
//			                           .filter(e->e.getCategory().getCategoryName()=category)
//			                           .collect(Collectors.toList());
//	return filteredList;
//	return CategoryRepo.getFoodItemByCategory(category);
//}

}
