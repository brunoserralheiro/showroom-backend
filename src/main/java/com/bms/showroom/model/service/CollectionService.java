package com.bms.showroom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;
import com.bms.showroom.model.entity.Collection;


@EnableMongoRepositories(basePackages = "com.bms.showroom.model.data")
@Service
public class CollectionService {

	@Autowired
	private CustomRepository customRepository;
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	public Collection findByName(String name) {
		
		return collectionRepository.findByName(name);
	}
	
	public List<Collection> findAll(){
		
		return collectionRepository.findAll();
	}
	
	public long updateCollection(String name, String description) {
		
		return customRepository.updateCollection(name, description);
	}
	
	
	public long setActiveCollection(String name,  boolean active) {
		
		return customRepository.setActiveCollection(name, active);
	}
	
	public  Collection saveCollection(Collection collection) {
		
		return customRepository.saveCollection(collection);
	}
	
}
