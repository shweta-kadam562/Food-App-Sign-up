package com.foodapp.rest.r.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.rest.r.model.Menu;
import com.foodapp.rest.r.service.MenuService;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@PostMapping("/add")
	public ResponseEntity<String> postMenu(@RequestBody Menu menu) {
		menuService.postMenu(menu);
		return ResponseEntity.status(HttpStatus.OK).body("Menu added...");
	}

	@GetMapping("/allmenu")
	public ResponseEntity<Object> getAllMenu() {
		List<Menu> optional = menuService.getAllMenu();

		return ResponseEntity.status(HttpStatus.OK).body(optional);
	}

	@GetMapping("/one/menu/{id}")
	public ResponseEntity<Object> getMenuById(@PathVariable("id") int id) {
		Optional<Menu> optional = menuService.getById(id);
		if (!optional.isPresent()) {
			ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Id given");
		}
		Menu menu = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(menu);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMenuById(@PathVariable("id") int id) {
		menuService.deleteMenuById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Menu deleted");
	}

	@GetMapping("/menu/{id}")
	public Menu getCategory(@PathVariable("id") int id) {
		Menu menuResponse = menuService.findByCategoryId(id);
		return menuResponse;
	}

	@GetMapping("/menu/{rid}")
	public Menu getRestaurant(@PathVariable("rid") int rid) {
		Menu menuResponse = menuService.findByRestaurantId(rid);
		return menuResponse;
	}

	@PutMapping("/one/{id}")
	public ResponseEntity<String> UpdateMenuById(@PathVariable("id") int id, @RequestBody Menu menu) {
		menuService.updateMenuById(menu);
		return ResponseEntity.status(HttpStatus.OK).body("Menu is updated");
	}

}
