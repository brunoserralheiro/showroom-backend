package com.bms.showroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.showroom.ShowroomBackendApplication;
import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;
import com.bms.showroom.model.entity.Collection;

@RestController
public class CollectionController {

	@Autowired
	private static CollectionRepository collectionRepository;
	
	@Autowired
	private static CustomRepository customRepository;
	
	
	
	@RequestMapping(  value="api/collection/{name}", method=RequestMethod.GET)
	public List<Collection> getCollection(@RequestParam(value="name", defaultValue = "")String name){
		
		List<Collection> collections = new ArrayList<>();
		if(!collections.isEmpty()) {
			return collections;
		
		}else {
			collections.add(new Collection("one", "desc one ", true));
			
			return collections;
		}
	}
	
	@SuppressWarnings("static-access")
	@GetMapping(value="api/collection")
	public List<Collection> getCollectionList(){
		
		List<Collection> collections = new ArrayList<Collection>(); 
				
		collections =	collectionRepository.findAll();
		
		if(!collections.isEmpty()) {
			return collections;
		
		}else {
			collections.add(new Collection("one", "desc one ", true));
			
			return collections;
		}
		
	}
}
