package com.bms.showroom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//	@Autowired
//	private CollectionService service;

	@GetMapping(value = "api/welcome")
	public ResponseEntity<String> welcome() {

		return ResponseEntity.ok().body("Welcome!");
	}

}
