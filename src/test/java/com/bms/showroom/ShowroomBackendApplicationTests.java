package com.bms.showroom;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.bms.showroom.config.AppConfig;
import com.bms.showroom.model.data.ShowroomCollectionRepository;
import com.bms.showroom.model.data.CustomShowroomRepository;
import com.bms.showroom.model.entity.ShowroomCollection;

//@DataMongoTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { AppConfig.class })
@SpringBootTest
class ShowroomBackendApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private ShowroomCollectionRepository showroomCollectionRepository;

	@Autowired
	private CustomShowroomRepository customShowroomRepository;

	private List<ShowroomCollection> collectionListToSave;
	
	public void testRepo() {

		
	}

	@Test
	public void findAllContainSameItemsAsSaved() {

//		given 	
		collectionListToSave = addSampleData();

//		when
		List<ShowroomCollection> fetchedCollectionList = showroomCollectionRepository.findAll();

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
		List<ShowroomCollection> fetchedCollectionList = showroomCollectionRepository.findAll();

//		then

		assertThat(collectionListToSave.size(), is(4));
		assertThat(fetchedCollectionList, hasSize(4));

	}

	@Test
	public void findOneContainsSameDescriptionValueAsUpdated() {

//		given
		collectionListToSave = addSampleData();
		ShowroomCollection collectionToUpdate = new ShowroomCollection("col1", "new desc", true);

//		when
		customShowroomRepository.updateShowroomCollection(collectionToUpdate.getName(), collectionToUpdate.getDescription());

//		then
		ShowroomCollection fetchedCollection = showroomCollectionRepository.findByName(collectionToUpdate.getName());

		assert (fetchedCollection.getDescription()).contains(collectionToUpdate.getDescription());

	}	

	@Test
	public void updateIsSetToDeactivated() {

//		given
		collectionListToSave = addSampleData();
		ShowroomCollection collectionToUpdate = new ShowroomCollection("col3", "desc3", true);

//		when
		customShowroomRepository.setActiveShowroomCollection(collectionToUpdate.getName(), false);

//		then
		ShowroomCollection fetchedCollection = showroomCollectionRepository.findByName(collectionToUpdate.getName());

		assertFalse(fetchedCollection.isActive());
	}

	public List<ShowroomCollection> addSampleData() {

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

}
