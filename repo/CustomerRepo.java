package com.foodapp.rest.r.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.rest.r.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

//	public Customer findByCustomerId(int id);

}
