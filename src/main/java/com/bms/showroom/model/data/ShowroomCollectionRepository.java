/**
 * 
 */
package com.bms.showroom.model.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.bms.showroom.model.entity.ShowroomCollection;

/**
 * @author Bruno Serralheiro
 *
 */

@Repository
public interface ShowroomCollectionRepository extends MongoRepository<ShowroomCollection, String>{
	
	ShowroomCollection findByName(String name);
	
	@Query("{active:'?true'}")
	List<ShowroomCollection> findShowroomCollectionsByActive(boolean active);
	
	
	
	
	

}
