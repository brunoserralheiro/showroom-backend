package com.bms.showroom.model.data;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.bms.showroom.model.entity.Collection;
import com.mongodb.client.result.UpdateResult;


@Component
public class CustomRepositoryImpl implements CustomRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@Override
	public long setActiveCollection(String name,  boolean active) {
		
		Query query = new Query(Criteria.where("name").is(name)	);
		Update update = new Update();
		
		update.set("active", active);
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Collection.class);
		
		if( result != null)return result.getModifiedCount();
		
		return 0L;
	}

	@Override
	public long updateCollection(String name, String description)  {
		
		Query query = new Query(Criteria.where("name").is(name)	);
		Update update = new Update();
		
		if(!description.isEmpty()) {
			update.set("description", description);
		}
		
		UpdateResult result = mongoTemplate.updateFirst(query, update, Collection.class);
		
		if( result != null)return result.getModifiedCount();
		
		return 0L;
	}

	@Override
	public Collection saveCollection(Collection collection) {
		
		
		
		return collection;
	}
	

	
}
