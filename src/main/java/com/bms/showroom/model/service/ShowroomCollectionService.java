package com.bms.showroom.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.bms.showroom.model.data.ShowroomCollectionRepository;
import com.bms.showroom.model.data.CustomShowroomRepository;
import com.bms.showroom.model.entity.ShowroomCollection;


@EnableMongoRepositories(basePackages = "com.bms.showroom.model.data")
@Service
public class ShowroomCollectionService {

	@Autowired
	private CustomShowroomRepository customShowroomRepository;
	
	@Autowired
	private ShowroomCollectionRepository showroomCollectionRepository;
	
	public ShowroomCollection findByName(String name) {
		
		return showroomCollectionRepository.findByName(name);
	}
	
	public List<ShowroomCollection> findAll(){
		
		return showroomCollectionRepository.findAll();
	}
	
	public long updateShowroomCollection(String name, String description) {
		
		return customShowroomRepository.updateShowroomCollection(name, description);
	}
	
	
	public long setActiveCollection(String name,  boolean active) {
		
		return customShowroomRepository.setActiveShowroomCollection(name, active);
	}
	
	public  ShowroomCollection saveCollection(ShowroomCollection showroomCollection) {
		
		return customShowroomRepository.saveCollection(showroomCollection);
	}
	
}
