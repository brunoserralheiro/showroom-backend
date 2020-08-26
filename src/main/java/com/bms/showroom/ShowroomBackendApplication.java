package com.bms.showroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;

@SpringBootApplication
public class ShowroomBackendApplication {

	
	@Autowired
	CollectionRepository collectionRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ShowroomBackendApplication.class, args);
	}

}
