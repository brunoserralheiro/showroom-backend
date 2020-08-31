/**
 * 
 */
package com.bms.showroom.model.data;

import com.bms.showroom.model.entity.ShowroomCollection;

/**
 * @author HP
 *
 */


public interface CustomShowroomRepository {

	long updateShowroomCollection(String name, String description);
	
	long setActiveShowroomCollection(String name,  boolean active);
	
	ShowroomCollection saveCollection(ShowroomCollection showroomCollection);
	
	
}
