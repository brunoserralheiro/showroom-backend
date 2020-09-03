package com.bms.showroom;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bms.showroom.model.data.ShowroomCollectionRepository;
import com.bms.showroom.model.data.CustomShowroomRepository;
import com.bms.showroom.model.data.UserRepository;
import com.bms.showroom.model.entity.ShowroomCollection;
import com.bms.showroom.model.entity.User;

@ComponentScan("com.bms.showroom")
@SpringBootApplication
public class ShowroomBackendApplication {

	private static ShowroomCollectionRepository showroomCollectionRepository;

	private static CustomShowroomRepository customShowroomRepository;

	private static UserRepository userRepository;

	/**
	 * 
	 */

	@Autowired
	public ShowroomBackendApplication(@Autowired ShowroomCollectionRepository showroomCollectionRepository,
			@Autowired CustomShowroomRepository customShowroomRepository, @Autowired UserRepository userRepository) {

		ShowroomBackendApplication.showroomCollectionRepository = showroomCollectionRepository;
		ShowroomBackendApplication.customShowroomRepository = customShowroomRepository;
		ShowroomBackendApplication.userRepository = userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(ShowroomBackendApplication.class, args);
		System.out.println("<<<<<<<<<<<<<<<<           START   >>>>>>>>>>>>");

		addData();


	}

	
	private static void addData() {

		
		
		List<User> dbUserList = userRepository.findAll();
		
		if (dbUserList.isEmpty()) {
			
			addUser();
		}
		for (User user : dbUserList) {
			
			System.out.println("<<<<<<<<<<<<<<<<<");
			System.out.println(user.getFirstName());
			System.out.println(">>>>>>>>>>>>>>>>>");
		}
		
		
		
		
			List<ShowroomCollection> dbShowroomCollectionList = showroomCollectionRepository.findAll();
			
			if (dbShowroomCollectionList.isEmpty()) {
				
				dbShowroomCollectionList = addShowroomCollections();
				
			}
			for (ShowroomCollection col : dbShowroomCollectionList) {
				
				System.out.println("<<<<<<<<<<<<<<<<<");
				System.out.println(col.getName());
				System.out.println(">>>>>>>>>>>>>>>>>");
				
			}
			
		
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	private static void addUser() {

		List <String> roles = new ArrayList<String>();
		roles.add("ROLE_ADMIN");
		
		User user = new User("bruno", passwordEncoder().encode("password"), "Bruno", "Serralheiro",roles,true,true, true, true, true);

		userRepository.save(user);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public static List<ShowroomCollection> addShowroomCollections() {

		System.out.println("Adding sample data");

		ShowroomCollection col1 = new ShowroomCollection("col1", "desc1", true);
		ShowroomCollection col2 = new ShowroomCollection("col2", "desc2", true);
		ShowroomCollection col3 = new ShowroomCollection("col3", "desc3", true);
		ShowroomCollection col4 = new ShowroomCollection("col4", "desc4", true);

		showroomCollectionRepository.deleteAll();
		showroomCollectionRepository.save(col1);
		showroomCollectionRepository.save(col2);
		showroomCollectionRepository.save(col3);
		showroomCollectionRepository.save(col4);

		List<ShowroomCollection> showroomCollections = new ArrayList<>();
		showroomCollections.add(col1);
		showroomCollections.add(col2);
		showroomCollections.add(col3);
		showroomCollections.add(col4);

		return showroomCollections;
	}
	
	@Bean
	  protected static BCryptPasswordEncoder passwordEncoder() {
	  
	  return new BCryptPasswordEncoder(); 
	  }

}
