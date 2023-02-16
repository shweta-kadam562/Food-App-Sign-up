package com.foodapp.rest.r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.rest.r.model.Customer;
import com.foodapp.rest.r.repo.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;
	public void postCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	public Optional<Customer> getById(int id) {
		// TODO Auto-generated method stub
		Optional<Customer> optional = customerRepo.findById(id);
		return optional;
	}

	public void deleteCustomerById(int id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(id);
	}

	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerRepo.save(customer);
	}

	public Optional<Customer> getCustomerById(int i) {
		// TODO Auto-generated method stub
		return null;
	}


}
