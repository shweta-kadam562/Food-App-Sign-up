package com.foodapp.rest.r.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.rest.r.model.Category;
import com.foodapp.rest.r.model.FoodItem;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

//  public List<FoodItem> getFoodItemByCategory(String category);

}
