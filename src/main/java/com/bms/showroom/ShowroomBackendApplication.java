package com.bms.showroom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;
import com.bms.showroom.model.entity.Collection;

@SpringBootApplication
public class ShowroomBackendApplication {

	
	
	private static CollectionRepository collectionRepository;
	
	
	private static CustomRepository customRepository;
	
	
	
	
	/**
	 * 
	 */
	
@Autowired
	public ShowroomBackendApplication(@Autowired CollectionRepository collectionRepository, @Autowired CustomRepository customRepository) {

		ShowroomBackendApplication.collectionRepository = collectionRepository;
		ShowroomBackendApplication.customRepository = customRepository;
	
	}



	public static void main(String[] args) {
		SpringApplication.run(ShowroomBackendApplication.class, args);
		
		List <Collection> colls =  addSampleData();
		
		
		
		List<Collection> dbList = collectionRepository.findAll();
		
		for(Collection col : dbList) {
			
			System.out.println("<<<<<<<<<<<<<<<<<");
			System.out.println(col.getName());
			System.out.println(">>>>>>>>>>>>>>>>>");
		}
		
				
	}
	
	
	
	private static List<Collection> addSampleData() {

		System.out.println("Adding sample data");

		Collection col1 = new Collection("col1", "desc1", true);
		Collection col2 = new Collection("col2", "desc2", true);
		Collection col3 = new Collection("col3", "desc3", true);
		Collection col4 = new Collection("col4", "desc4", true);

		
//		collectionRepository.deleteAll();
		collectionRepository.save(col1);
		collectionRepository.save(col2);
		collectionRepository.save(col3);
		collectionRepository.save(col4);

		List<Collection> collections = new ArrayList<>();
		collections.add(col1);
		collections.add(col2);
		collections.add(col3);
		collections.add(col4);

		return collections;
	}

}
