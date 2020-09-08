package com.bms.showroom.model.data;

import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bms.showroom.model.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUsername(String username);
	
	Stream<User> findByActiveTrue();	
	
	

}
