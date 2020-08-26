/**
 * 
 */
package com.bms.showroom.model.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bms.showroom.model.entity.Collection;

/**
 * @author Bruno Serralheiro
 *
 */
public interface CollectionRepository extends MongoRepository<Collection, String>{
	
	Collection findByName(String name);
	
	@Query("{active:'?true'}")
	List<Collection> findCollectionsByActive(boolean active);
	
	
	
	
	

}
