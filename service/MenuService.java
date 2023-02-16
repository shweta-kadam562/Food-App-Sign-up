package com.foodapp.rest.r.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.foodapp.rest.r.model.Menu;
import com.foodapp.rest.r.repo.MenuRepo;

@Service
public class MenuService {

	@Autowired
	private MenuRepo menuRepo;

	public void postMenu(Menu menu) {
		menuRepo.save(menu);
	}

	public Optional<Menu> getById(int id) {
		// TODO Auto-generated method stub
		Optional<Menu> optional = menuRepo.findById(id);
		return optional;
	}

	public void deleteMenuById(int id) {
		// TODO Auto-generated method stub
		menuRepo.deleteById(id);
	}

	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		return menuRepo.findAll();
	}

	public void updateMenuById(Menu menu) {
		// TODO Auto-generated method stub
		menuRepo.save(menu);
	}

	public Menu findByCategoryId(int id) {
		// TODO Auto-generated method stub
		Menu menu = menuRepo.findByCategoryId(id);
		return menu;
	}

	public Menu findByRestaurantId(int id) {
		Menu menu = menuRepo.findByRestaurantId(id);
		return menu;
	}

}
