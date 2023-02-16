package com.foodapp.rest.r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.rest.r.model.Category;
import com.foodapp.rest.r.model.Customer;
import com.foodapp.rest.r.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public void postCategory(Category category) {
		categoryRepo.save(category);
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll();
	}

	public Optional<Category> getById(int id) {
		// TODO Auto-generated method stub
		Optional<Category> optional = categoryRepo.findById(id);
		return optional;
	}

	public void deleteCategoryById(int id) {
		categoryRepo.deleteById(id);
	}

	public void updateCategoryById(Category category) {
		categoryRepo.save(category);

	}

}
