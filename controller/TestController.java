package com.foodapp.rest.r.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.rest.r.model.Person;
import com.foodapp.rest.r.repo.PersonRepo;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class TestController {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/person/add")
	public ResponseEntity<Object> postUser(@RequestBody Person person) {
		Person pDB = personRepo.getPersonByEmail(person.getEmail());

		if(pDB != null) {
			Message m = new Message();
			m.setMsg("Email already registered");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(m);
		}
		
		
		 String encodedPassword = passwordEncoder.encode(person.getPassword());
		// attach encoded password to user
		person.setPassword(encodedPassword);
		personRepo.save(person);
//		return ResponseEntity.status(HttpStatus.OK).body("Signup Success");
		return ResponseEntity.status(HttpStatus.OK).body(personRepo.save(person));

	}
	@GetMapping("/person/all")
	public List<Person> getAllPerson() {
		return personRepo.findAll();
	}
}


class Message{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	} 


}