package com.foodapp.rest.r.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodapp.rest.r.model.Restaurant;


public interface RestaurantRepo extends JpaRepository<Restaurant, Integer>{

	static Object findByRestaurantId(int i) {
		// TODO Auto-generated method stub
		return null;
	}
//	@Query("select r from Restaurant r join r.menu m where m.id=?1")
//	List<Restaurant> getMenuByRestaurantId(int mid);

}
