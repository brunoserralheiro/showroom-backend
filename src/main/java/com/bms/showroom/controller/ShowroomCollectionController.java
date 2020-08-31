package com.bms.showroom.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bms.showroom.model.entity.ShowroomCollection;
import com.bms.showroom.model.service.ShowroomCollectionService;

@RestController
public class ShowroomCollectionController {

	@Autowired
	private ShowroomCollectionService service;
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(  value="api/collection/{name}", method=RequestMethod.GET)
	public ShowroomCollection getCollection(@RequestParam(value="name", defaultValue = "")String name){
		
			ShowroomCollection showroomCollection  = service.findByName(name);
		
			if (showroomCollection == null) return  new ShowroomCollection("foo", "bar", false);
			
			return  showroomCollection;
					
					
					
		
	}
	
	@GetMapping(value="api/collection")
	public List<ShowroomCollection> getCollectionList(){
		
		List<ShowroomCollection> showroomCollections = new ArrayList<ShowroomCollection>(); 
				
		showroomCollections =	service.findAll();
		
		if(!showroomCollections.isEmpty()) {
			return showroomCollections;
		
		}else {
			showroomCollections.add(new ShowroomCollection("one", "desc one ", true));
			
			return showroomCollections;
		}
		
	}
}
