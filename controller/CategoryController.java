package com.foodapp.rest.r.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.rest.r.model.Category;
import com.foodapp.rest.r.service.CategoryService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<String> postCategory(@RequestBody Category category) {
		categoryService.postCategory(category);
		return ResponseEntity.status(HttpStatus.OK).body("Category added...");
	}

	@GetMapping("/allcategories")
	public List<Category> getAllCategory() {
		List<Category> list = categoryService.getAllCategories();
		return list;
	}

	@GetMapping("/one/category/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable("id") int id) {
		Optional<Category> optional = categoryService.getById(id);
		if (!optional.isPresent()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id given");
		}
		Category category = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(category);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCategoryById(@PathVariable("id") int id){
		categoryService.deleteCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
	}
	
	@PutMapping("/one/{id}")
	public ResponseEntity<String> UpdateCategoryById(@PathVariable("id") int id, @RequestBody Category category) {
		categoryService.updateCategoryById(category);
		return ResponseEntity.status(HttpStatus.OK).body("Category is updated");
	}
//	@GetMapping("/getone/{id}")
//	public Category getCategoryById(@PathVariable ("id") int id) {
//		Optional<Category> optional = categoryService.getCategoryById(id);
//		if(!optional.isPresent()) 
//			throw new ResourceNotFoundException("Invalid ID");

//	return optional.get();
//	}

}

