package com.bms.showroom.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


// change for JPA and MySQL
//@Table
//@Entity


@Data
@Document(collection = "user")
public class User {

//	change for JPA and MySQL
//	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Id
	private String id;
	@Indexed(unique=true, direction=IndexDirection.DESCENDING)
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private  boolean accountNonExpired = true;
	private  boolean accountNonLocked = true;
	private  boolean credentialsNonExpired ;
	private  boolean enabled ;
	private boolean active ;
	
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param active
	 */
	public User(String username, String password, 
				String firstName, String lastName,  
				boolean active, boolean enabled, 
				boolean credentialsNonExpired) {
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.active = active;
		this.enabled = enabled;
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	
	


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}





	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}





	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
}
