package com.bms.showroom;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bms.showroom.model.data.CollectionRepository;
import com.bms.showroom.model.data.CustomRepository;
import com.bms.showroom.model.entity.Collection;

//@DataMongoTest
@RunWith(SpringRunner.class)
@SpringBootTest
class ShowroomBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired	
	private CollectionRepository collectionRepository;

	@Autowired
	private CustomRepository customRepository;

	private List<Collection> collectionListToSave;
	
	public void testRepo() {

		
	}

	@Test
	public void findAllContainSameItemsAsSaved() {

//		given 	
		collectionListToSave = addSampleData();

//		when
		List<Collection> fetchedCollectionList = collectionRepository.findAll();

//		then
		for (int i = 0; i < fetchedCollectionList.size(); i++) {

//			System.out.printf("Fetched: %s, Saved: %s \n", fetchedCollectionList.get(i).getName(), collectionListToSave.get(i).getName() );
			assert (fetchedCollectionList.get(i).getName()).contains(collectionListToSave.get(i).getName());

		}

	}

	@Test
	public void findAllHaveSameSizeAsSaved() {

//		given 
		collectionListToSave = addSampleData();

//		when
		List<Collection> fetchedCollectionList = collectionRepository.findAll();

//		then

		assertThat(collectionListToSave.size(), is(4));
		assertThat(fetchedCollectionList, hasSize(4));

	}

	@Test
	public void findOneContainsSameDescriptionValueAsUpdated() {

//		given
		collectionListToSave = addSampleData();
		Collection collectionToUpdate = new Collection("col1", "new desc", true);

//		when
		customRepository.updateCollection(collectionToUpdate.getName(), collectionToUpdate.getDescription());

//		then
		Collection fetchedCollection = collectionRepository.findByName(collectionToUpdate.getName());

		assert (fetchedCollection.getDescription()).contains(collectionToUpdate.getDescription());

	}

	@Test
	public void updateIsSetToDeactivated() {

//		given
		collectionListToSave = addSampleData();
		Collection collectionToUpdate = new Collection("col3", "desc3", true);

//		when
		customRepository.setActiveCollection(collectionToUpdate.getName(), false);

//		then
		Collection fetchedCollection = collectionRepository.findByName(collectionToUpdate.getName());

		assertFalse(fetchedCollection.isActive());
	}

	public List<Collection> addSampleData() {

		System.out.println("Adding sample data");

		Collection col1 = new Collection("col1", "desc1", true);
		Collection col2 = new Collection("col2", "desc2", true);
		Collection col3 = new Collection("col3", "desc3", true);
		Collection col4 = new Collection("col4", "desc4", true);

		
		collectionRepository.deleteAll();
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
