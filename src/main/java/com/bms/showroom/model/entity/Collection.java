/**
 * 
 */
package com.bms.showroom.model.entity;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

/**
 * @author Bruno
 *
 */


@Data
@Document(collection = "collection")
public class Collection {
	
	

//	@MongoId(value = FieldType.OBJECT_ID)
	@Id
	private String id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING)
	private String name;
	private String description;
	private boolean active;
	
	
	/**
	 * @param name
	 * @param description
	 * @param active
	 */
	public Collection(String name, String description, boolean active) {
		this.name = name;
		this.description = description;
		this.active = active;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

}
