/**
 * 
 */
package com.bms.showroom.model.data;

/**
 * @author HP
 *
 */
public interface CustomRepository {

	long updateCollection(String name, String description);
	
	long setActiveCollection(String name,  boolean active);
	
	
}
