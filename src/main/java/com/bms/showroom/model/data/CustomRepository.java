/**
 * 
 */
package com.bms.showroom.model.data;

import com.bms.showroom.model.entity.Collection;

/**
 * @author HP
 *
 */
public interface CustomRepository {

	long updateCollection(String name, String description);
	
	long setActiveCollection(String name,  boolean active);
	
	Collection saveCollection(Collection collection);
	
	
}
